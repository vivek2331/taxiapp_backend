package com.example.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project2.entity.Orrder;
import com.example.project2.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Orrder, Long> {
	 Orrder findByOrderid(long id);
	 List<Orrder> findByUserAndStatus(User user, String status);
}
