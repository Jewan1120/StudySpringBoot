package com.jewan.learnspringframework.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @JsonProperty("user_name") // 표기 형식을 user_name으로 변경
    private String name;

    @Past(message = "Birth Date should be in the past") // 현재 기준 과거의 값만 허용
    @JsonProperty("birth_date") // 표기 형식을 birth_date로 변경
    private LocalDate birthDate;

    public User() {

    }

    public User(Integer id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "user [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }

}
