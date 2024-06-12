package com.jewan.learnspringframework.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// JPA를 이용해서 자동으로 매핑 가능 -> 엔티티 지정
// JPA를 사용할 때마다 Java Bean을 테이블에 매핑
// @Entity(name="Course_Details") 테이블 명과 class의 이름과 다를 경우 name 지정
@Entity
public class Course {

    @Id // PK
    private long id;
    @Column(name = "name")
    private String name;
    // @Column(name = "author") 변수명과 DB칼럼명과 같다면 생략 가능
    private String author;

    public Course() {

    }

    public Course(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
