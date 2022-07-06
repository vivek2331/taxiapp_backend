package com.example.TaxiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaxiProject.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
