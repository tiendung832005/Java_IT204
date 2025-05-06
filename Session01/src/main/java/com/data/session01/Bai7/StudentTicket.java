package com.data.session01.Bai7;

public class StudentTicket {
    private String fullName;
    private String className;
    private String vehicleType;
    private String licensePlate;

    public StudentTicket(String fullName, String className, String vehicleType, String licensePlate) {
        this.fullName = fullName;
        this.className = className;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getClassName() {
        return className;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
