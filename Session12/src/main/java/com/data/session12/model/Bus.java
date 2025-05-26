package com.data.session12.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Bus {
    private int id;

    @NotBlank(message = "Biển số xe không được để trống")
    private String licensePlate;

    @NotBlank(message = "Loại xe không được để trống")
    private String busType;

    @NotNull(message = "Số hàng ghế không được để trống")
    private int rowSeat;

    @NotNull(message = "Số cột ghế không được để trống")
    private int colSeat;

    private int totalSeat;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getRowSeat() {
        return rowSeat;
    }

    public void setRowSeat(int rowSeat) {
        this.rowSeat = rowSeat;
    }

    public int getColSeat() {
        return colSeat;
    }

    public void setColSeat(int colSeat) {
        this.colSeat = colSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}