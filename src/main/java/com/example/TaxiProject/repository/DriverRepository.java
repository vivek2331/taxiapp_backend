package com.example.project2.repository;

import java.util.List;

import com.example.project2.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long>{
    //get driver by driver id
    Driver findDriverById(long id);
}

