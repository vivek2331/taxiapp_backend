package com.example.TaxiProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "rideId")
    private RideDetails rideDetails;

    public Driver(){

    }

    public Driver(long id,String name, long phoneNumber, String status) {
        this.id=id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RideDetails getRideDetails() {
        return rideDetails;
    }

    public void setRideDetails(RideDetails rideDetails) {
        this.rideDetails = rideDetails;
    }



}

