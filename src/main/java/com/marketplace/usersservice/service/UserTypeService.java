package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.UserTypeDTO;
import com.marketplace.usersservice.model.UserType;
import com.marketplace.usersservice.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService implements IUserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;
    @Override
    public UserType save(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setUserType(userTypeDTO.getUserType());
        return userTypeRepository.save(userType);
    }
}