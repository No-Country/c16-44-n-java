    package com.marketplace.usersservice.dto;

    import com.marketplace.usersservice.model.UserType;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class UserDTO {
        private String name;
        private String lastName;
        private String email;
        private String address;
        private String password;
        private UserType userType;
    }
