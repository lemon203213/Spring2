package com.example.week4springhwk.dto;

import lombok.Getter;

@Getter
public class SigninREquestDto {
    private final String nickname;
    private final String password;
//로그인
    public SigninREquestDto(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }
}
