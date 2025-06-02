package com.data.session16a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Long id;
    private User user;
    private BusTrip trip;
    private String listSeat;
    private double totalMoney;
    private LocalDate departureDate;
}
