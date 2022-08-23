package com.example.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private UserGrade userGrade;

    public User(Long id, String name, UserGrade userGrade) {
        this.id = id;
        this.name = name;
        this.userGrade = userGrade;
    }
}
