package com.jewan.learnspringframework.security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    // LDAP or Database
    // InMemory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("jewan", "taekbae");
        UserDetails userDetails2 = createNewUser("taekbae", "jewan");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        // 빌드 패턴
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username)
                .password(password).roles("USER", "ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 따라서 h2 console을 이용하려면 CSRF를 비활성화 해야함

    // SecurityFilterChain : HTTP 요청을 처리하기 위해 필터 체인을 정의하는 인터페이스
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 HTTP 요청에 대해 인증을 요구
        http.authorizeHttpRequests(auth -> auth
                // 해당 줄이 있으면 h2 콘솔은 아무나 접근 가능
                //.requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated());

        // 폼 기반 로그인을 기본 설정으로 활성화
        http.formLogin(withDefaults());

        // CSRF(Cross-Site Request Forgery) 보호를 비활성화
        http.csrf().disable();

        // X-Frame-Options 헤더를 비활성화
        // H2 콘솔과 같이 iframe을 사용하는 애플리케이션이 올바르게 작동
        http.headers().frameOptions().disable();

        // 구성된 HttpSecurity 객체를 빌드하여 SecurityFilterChain을 반환
        return http.build();
    }
}
