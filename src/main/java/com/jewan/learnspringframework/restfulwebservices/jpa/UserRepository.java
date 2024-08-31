package com.jewan.learnspringframework.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewan.learnspringframework.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
