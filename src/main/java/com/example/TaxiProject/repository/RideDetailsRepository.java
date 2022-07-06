package com.example.project2.repository;

import java.util.List;

import com.example.project2.entity.RideDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideDetailsRepository extends JpaRepository<RideDetails, Long>{
	List<RideDetails> findByUserId(long id);

	//get ride details by ride_id
	RideDetails findRideDetailsByRideId(long id);
}
