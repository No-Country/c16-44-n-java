package com.marketplace.administratorservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "admin")
@Getter
@Setter
@NoArgsConstructor
public class AdminEntity {

    @Id
    private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;
}
