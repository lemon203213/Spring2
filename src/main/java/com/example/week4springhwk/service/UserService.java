package com.example.week4springhwk.service;

import com.example.week4springhwk.dto.SignupRequestDto;
import com.example.week4springhwk.model.User;
import com.example.week4springhwk.model.UserRoleEnum;
import com.example.week4springhwk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public Map<String, String> validateHandling(Errors errors) {//유효성 체크
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
    public void registerUser(SignupRequestDto requestDto) {
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getPasswordCheck();

        Optional<User> found = userRepository.findByNickname(nickname);// 회원 ID 중복 확인
        if (found.isPresent()) {
            throw new IllegalArgumentException("이미 사용된 닉네임입니다.");
        }

        if(checkPassword.equals(password)) {//password가 일치하면 암호화
            password = passwordEncoder.encode(requestDto.getPasswordCheck());
        }

        User user = new User(nickname, password);
        userRepository.save(user);
    }
}
