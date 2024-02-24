package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dtos.UserDTO;
import com.marketplace.usersservice.dtos.UserLoginDTO;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.model.UserType;
import com.marketplace.usersservice.repository.UserRepository;
import com.marketplace.usersservice.repository.UserTypeRepository;
import com.marketplace.usersservice.security.JwtTokenProvider;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;// Gestor de autenticación para verificar las credenciales enviadas durante el inicio de sesión

    @Autowired
    private JwtTokenProvider jwtTokenProvider;// Proveedor de tokens JWT encargado de generar y validar tokens de autenticación


    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            Hibernate.initialize(user.getUserType());
        }
        return users;
    }
    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with ID " + id + " no found."));
    }
    @Override
    public User save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        UserType userType;
        if (userDTO.getUserType() != null && userDTO.getUserType().getId() != null) {
            Optional<UserType> optionalUserType = userTypeRepository.findById(userDTO.getUserType().getId());
            userType = optionalUserType.orElseThrow(() -> new IllegalArgumentException("UserType with ID " + userDTO.getUserType().getId() + " not found."));
        } else {
            // Asigna el UserType predeterminado si userType es nulo o su id es nulo
            userType = UserType.getDefaultUserType();
        }

        user.setUserType(userType);
        return userRepository.save(user);

    }
    @Override
    public User update(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with ID " + id + " no found."));
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setPassword(userDTO.getPassword());

        UserType userType = userTypeRepository.findById(userDTO.getUserType().getId()).orElseThrow(
                () -> new IllegalArgumentException("UserType with ID " + userDTO.getUserType() + " no found."));

        user.setUserType(userType);
        return userRepository.save(user);
    }
    public User patch(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with ID " + id + " no found."));
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getLastName() != null) {
            user.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getAddress() != null) {
            user.setAddress(userDTO.getAddress());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getUserType() != null) {
            UserType userType = userTypeRepository.findById(userDTO.getUserType().getId()).orElseThrow(
                    () -> new IllegalArgumentException("UserType with ID " + userDTO.getUserType() + " no found."));
            user.setUserType(userType);
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new IllegalArgumentException("User with ID " + id + " no found.");
        }
    }

    @Override
    public String authentication(UserLoginDTO user) throws Exception{
        
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        // Establece la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        //Se genera el token
        String token = jwtTokenProvider.generateToken(authentication);

        return token;
        
    }


}
