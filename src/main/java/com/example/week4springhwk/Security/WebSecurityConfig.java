package com.example.week4springhwk.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean//비밀번호 암호화를 위해 암호화 알고리즘 빈으로
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
    // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
        // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()//images 뒤에오는 경로를 허용해주겠다
        // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
        // 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
        // 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()

        // 로그인 기능 허용
                .formLogin()
            // 로그인 View 제공 (GET /user/login)
                .loginPage("/user/login")
            // 로그인 처리 (POST /user/login)
                .loginProcessingUrl("/user/login")
            // 로그인 처리 후 성공 시 URL
                .defaultSuccessUrl("/")
            // 로그인 처리 후 실패 시 URL
                .failureUrl("/user/login?error")
                .permitAll()
                .and()

        // 로그아웃 기능 허용
                .logout()
            // 로그아웃 처리 URL
                .logoutUrl("/user/logout")
                .permitAll()
                .and()
                .exceptionHandling()
                //접근 불가 페이지
               .accessDeniedPage("/forbidden.html");
    }
}
