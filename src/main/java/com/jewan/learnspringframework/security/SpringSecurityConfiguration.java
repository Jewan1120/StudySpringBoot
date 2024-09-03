package com.jewan.learnspringframework.security;

import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class SpringSecurityConfiguration {

    // LDAP

    // 1. Database
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        var user = User.withUsername("jewan").password("jewan").passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER").build();
        var admin = User.withUsername("admin").password("1234").passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("ADMIN").build();

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user); // 인코딩 된 비밀번호로 저장됨
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    // 2. InMemory
    // @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("jewan", "taekbae");
        UserDetails userDetails2 = createNewUser("taekbae", "jewan");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        // 빌드 패턴
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
                .roles("USER", "ADMIN").build();
        return userDetails;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 따라서 h2 console을 이용하려면 CSRF를 비활성화 해야함

    // SecurityFilterChain : HTTP 요청을 처리하기 위해 필터 체인을 정의하는 인터페이스
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 HTTP 요청에 대해 인증을 요구
        http.authorizeHttpRequests(auth -> auth
                // 해당 줄이 있으면 h2 콘솔은 아무나 접근 가능
                // .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated());

        // 세션 정책
        // SessionCreationPolicy.STATELESS -> Spring Security에서 HTTP 세션을 생성하지도, 사용하지도 않음
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic();

        // 폼 기반 로그인을 기본 설정으로 활성화
        // http.formLogin(withDefaults());

        // CSRF(Cross-Site Request Forgery) 보호를 비활성화 -> RestAPI는 상태가 없기 때문에 CSRF를 사용하지
        // 않음
        http.csrf().disable();

        // X-Frame-Options 헤더를 비활성화
        // H2 콘솔과 같이 iframe을 사용하는 애플리케이션이 올바르게 작동
        // disable(): X-Frame-Options를 완전히 비활성화
        // sameOrigin(): 동일한 출처에서만 <iframe> 사용을 허용
        http.headers().frameOptions().sameOrigin();

        // 구성된 HttpSecurity 객체를 빌드하여 SecurityFilterChain을 반환
        return http.build();
    }
}
