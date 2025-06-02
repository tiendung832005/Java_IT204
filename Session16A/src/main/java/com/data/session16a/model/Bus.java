package com.data.session16a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

    private Long id;
    private String licensePlate;
    private String busType;
    private int rowSeat;
    private int colSeat;
    private int totalSeat;
    private String image;
}
