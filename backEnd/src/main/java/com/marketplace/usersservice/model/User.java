    package com.marketplace.usersservice.model;


    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity(name = "user")
    public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 30, message = "Name should be less than 30 characters")
    @Column(length = 30)
    private String name;
    @NotNull
    @Size(max = 30, message = "Surname should be less than 30 characters")
    @Column(name= "last_name", length = 30)
    private String lastName;
    @NotNull
    @Size(max = 30, message = "Email should be less than 30 characters")
    @Column(length = 30)
    private String email;
    @NotNull
    @Size(max = 50, message = "Address should be less than 50 characters")
    @Column(length = 50)
    private String address;
    @NotNull
    @Size(max = 15, message = "Password should be less than 15 characters")
    @Column(length = 15)
    private String password;
    @ManyToOne()
    @JoinColumn(name = "user_type_id")
    private UserType userType;
    
    public User(Long id){
        this.id = id;
    }
}
