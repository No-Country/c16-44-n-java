package com.marketplace.usersservice.service;


import com.marketplace.usersservice.dto.UserTypeDTO;

import com.marketplace.usersservice.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTypeService  {
    UserType save(UserTypeDTO userTypeDTO);
}
