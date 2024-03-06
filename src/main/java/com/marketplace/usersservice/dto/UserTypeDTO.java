package com.marketplace.usersservice.dto;

import com.marketplace.usersservice.model.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTypeDTO {


    private Long id;
    private String userType;


}
