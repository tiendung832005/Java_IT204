package com.data.session15.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private int idUser;
    private String recipientName;
    private String address;
    private String phoneNumber;
}
