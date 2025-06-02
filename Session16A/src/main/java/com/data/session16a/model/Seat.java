package com.data.session16a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    private Long id;
    private String nameSeat;
    private double price;
    private Bus bus;
    private String status;
}
