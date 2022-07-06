package com.example.TaxiProject.repository;

import com.example.TaxiProject.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findDriverById(long id);
}

