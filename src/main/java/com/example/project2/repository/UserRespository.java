package com.example.project2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project2.entity.User;

public interface UserRespository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
