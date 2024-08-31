package com.jewan.learnspringframework.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details") // h2에 자동으로 Table 생성
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @JsonProperty("user_name") // 표기 형식을 user_name으로 변경 -> JSON형태의 POST로 값을 받을 때도 매핑을 하려면 바꾼 변수명으로 할당해야 함
    private String name;

    @Past(message = "Birth Date should be in the past") // 현재 기준 과거의 값만 허용
    @JsonProperty("birth_date") // 표기 형식을 birth_date로 변경
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user") // 일대다 관계
    @JsonIgnore
    private List<Post> posts;
    
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
