package com.example.TaxiProject.repository;

import java.util.List;

import com.example.TaxiProject.entities.RideDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideDetailsRepository extends JpaRepository<RideDetails, Long> {
    //get all rides of that user id
    List<RideDetails> findByUserId(long id);

    //get ride details by ride_id
    RideDetails findRideDetailsByRideId(long id);
}
