package com.example.week4springhwk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SignupRequestDto {
    @NotBlank(message ="닉네임을 입력해주세요.")
    @Pattern(regexp="^[a-zA-z0-9]{3,}$",message ="닉네임은 알파벳 대소문자와 숫자로 3자 이상되어야 합니다." )
    private String nickname;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, message = "4자 이상 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인해 주세요")
    private String passwordCheck;
}
