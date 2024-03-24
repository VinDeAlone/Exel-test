package com.exelTest.demoService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exelTest.demoService.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
