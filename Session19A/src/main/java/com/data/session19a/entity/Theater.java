package com.data.session19a.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "theaters")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Theater name cannot be empty")
    private String theaterName;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Min(value = 1, message = "Number of screen rooms must be greater than 0")
    private Integer numberScreenRoom;

    private boolean status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberScreenRoom() {
        return numberScreenRoom;
    }

    public void setNumberScreenRoom(Integer numberScreenRoom) {
        this.numberScreenRoom = numberScreenRoom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}