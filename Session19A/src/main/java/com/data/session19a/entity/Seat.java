package com.data.session19a.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ghế không được để trống")
    private String seatName;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "screen_room_id", nullable = false)
    private ScreenRoom screenRoom;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ScreenRoom getScreenRoom() {
        return screenRoom;
    }

    public void setScreenRoom(ScreenRoom screenRoom) {
        this.screenRoom = screenRoom;
    }
}