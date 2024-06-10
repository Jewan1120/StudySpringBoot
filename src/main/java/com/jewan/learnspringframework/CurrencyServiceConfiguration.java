package com.jewan.learnspringframework;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// currency-service.url=
// currency-service.username=
// currency-service.key=

@ConfigurationProperties(prefix = "currency-service")
// 설정파일로 쓰겠다는 어노테이션, 접두사 정의
// 값 설정은 application.properties에서
@Component
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
