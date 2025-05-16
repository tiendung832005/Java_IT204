package com.data.session09.model;

public class Seat {
    private Long id;
    private Long screenRoomId;
    private Double price = 50000.0;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(Long screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
