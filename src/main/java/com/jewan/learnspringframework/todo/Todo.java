package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// JPA -> 테이블에 자동으로 맵핑
// JPA(Java Persistence API)를 사용하여 데이터베이스 테이블에 매핑되는 엔티티 클래스
// 스프링이 사전 설정 과정에서 해당 어노테이션이 있으면 자동으로 해당 엔티티로 테이블을 작성함
// Entity(name = "test")로 테이블 명을 지정해줄 수 있음.
@Entity
public class Todo {

    @Id // 엔티티의 기본 키(primary key)
    @GeneratedValue // @GeneratedValue(strategy = GenerationType.IDENTITY): 기본 키 값이 데이터베이스에서 자동으로 생성
    private int id;
    private String username;
    
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate; // -> 문자열에 대문자가 있다면 DB에서는 _로 표현
    private boolean done;

    // 명시적으로 기본 생성자가 정의되지 않으면 자동으로 생성되지만
    // 다른 생성자가 정의된 경우에는 기본 생성자가 자동으로 생성되지 않으므로
    // 스프링 MVC는 폼 데이터를 바인딩할 때 기본 생성자가 필요
    public Todo() {

    }

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + done + "]";
    }
}
