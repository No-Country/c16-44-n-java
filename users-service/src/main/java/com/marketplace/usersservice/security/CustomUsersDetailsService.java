package com.marketplace.usersservice.security;


import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.model.UserType;
import com.marketplace.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service//ya que se va necesitar trabajar con la base de datos
public class CustomUsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    // Convierte un UserType en una colección de autoridades GrantedAuthority
    private Collection<? extends GrantedAuthority> mapToAuthority(UserType userType) {
        // Verifica si el UserType es nulo
        if (userType == null) {
            // Manejar el caso de que no haya UserType asignado al usuario
            return Collections.emptyList(); // Retorna una colección vacía de autoridades
        }

        // Retorna una lista con una sola autoridad creada a partir del tipo de usuario
        return Collections.singletonList(new SimpleGrantedAuthority(userType.getUserType()));
    }



    // Implementación del método de la interfaz UserDetailsService para cargar usuarios por su correo electrónico
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca un usuario en el repositorio por su correo electrónico
        User user = userRepository.findByEmail(email).get();

        // Verifica si el usuario no fue encontrado
        if (user == null) {
            // Lanza una excepción indicando que el usuario no fue encontrado con el correo electrónico proporcionado
            throw new UsernameNotFoundException("Usuario no encontrado con el correo electrónico: " + email);
        }

        // Crea y retorna una instancia de UserDetails con la información del usuario y sus autoridades
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapToAuthority(user.getUserType())
        );
    }




}
