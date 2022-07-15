package com.example.week4springhwk.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) //자바 내에서는 Enum, DB전달할 때는 String
    private UserRoleEnum role;

    public User(String nickname, String password, UserRoleEnum role) {
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }
}


