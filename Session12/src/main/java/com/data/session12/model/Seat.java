package com.data.session12.model;


public class Seat {
    private int id;
    private String nameSeat;
    private double price;
    private int busId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSeat() {
        return nameSeat;
    }

    public void setNameSeat(String nameSeat) {
        this.nameSeat = nameSeat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
