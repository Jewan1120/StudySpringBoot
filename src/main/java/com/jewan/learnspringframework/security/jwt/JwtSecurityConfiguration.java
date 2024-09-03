package com.jewan.learnspringframework.security.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JwtSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); // JWT 토큰을 사용해서 인증하라는 의미

        return http.build();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        var user = User.withUsername("jewan").password("1234").passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER").build();
        var admin = User.withUsername("taekbae").password("1234").passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("ADMIN", "USER").build();
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            // RSA 알고리즘을 사용하여 키 페어를 생성하는 KeyPairGenerator 객체를 생성
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // 키 페어의 크기를 2048 비트로 설정 -> 암호화의 강도
            keyPairGenerator.initialize(2048);
            // RSA 키 페어(공개 키와 개인 키)를 생성하여 반환.
            return keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
        // KeyPair에서 RSA 공개 키를 가져와 RSAKey 객체를 생성하는 빌더를 초기화
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                // 빌더에 RSA 개인 키를 설정
                .privateKey(keyPair.getPrivate())
                // RSAKey의 고유 식별자(ID)를 무작위로 생성하여 설정
                .keyID(UUID.randomUUID().toString())
                // 빌더로부터 최종적으로 RSAKey 객체를 생성하여 반환
                .build();
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
        // 주어진 RSAKey를 포함하는 JWKSet 객체를 생성
        var jwkSet = new JWKSet(rsaKey);
        // JWKSelector가 주어진 JWKSet에서 적절한 JWK(JSON Web Key)를 선택하도록 하는 JWKSource를 반환
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public JwtDecoder jwtDecode(RSAKey rsaKey) throws JOSEException {
        // RSAKey로부터 공개 키를 가져와서 NimbusJwtDecoder 객체를 생성
        // 이 디코더는 JWT를 검증할 때 RSA 공개 키를 사용
        return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        // JWKSource를 사용하여 NimbusJwtEncoder 객체를 생성
        // 이 인코더는 JWT를 생성할 때 사용되며, 제공된 JWKSource를 통해 키를 관리
        return new NimbusJwtEncoder(jwkSource);
    }

}
