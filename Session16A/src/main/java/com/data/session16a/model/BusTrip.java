package com.data.session16a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusTrip {
    private Long id;
    private String departurePoint;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Bus bus;
    private int seatsAvailable;
    private String image;
}
