package com.jewan.learnspringframework.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewan.learnspringframework.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
