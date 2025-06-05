package com.data.session19a.service;

import com.data.session19a.entity.ScreenRoom;
import com.data.session19a.entity.Seat;
import com.data.session19a.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenRoomService {

    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    public void createScreenRoom(ScreenRoom screenRoom) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= screenRoom.getCapacity(); i++) {
            Seat seat = new Seat();
            seat.setSeatName("A" + i);
            seat.setStatus(true);
            seat.setScreenRoom(screenRoom);
            seats.add(seat);
        }
        screenRoom.setSeats(seats);
        screenRoomRepository.saveScreenRoom(screenRoom);
    }

    public void updateScreenRoomCapacity(ScreenRoom screenRoom, int newCapacity) {
        int currentCapacity = screenRoom.getCapacity();
        List<Seat> seats = screenRoom.getSeats();

        if (newCapacity > currentCapacity) {
            for (int i = currentCapacity + 1; i <= newCapacity; i++) {
                Seat seat = new Seat();
                seat.setSeatName("A" + i);
                seat.setStatus(true);
                seat.setScreenRoom(screenRoom);
                seats.add(seat);
            }
        } else if (newCapacity < currentCapacity) {
            seats.subList(newCapacity, currentCapacity).clear();
        }

        screenRoom.setCapacity(newCapacity);
        screenRoomRepository.updateScreenRoom(screenRoom);
    }

    public List<ScreenRoom> findActiveScreenRooms() {
        return screenRoomRepository.findActiveScreenRooms();
    }

    public ScreenRoom findScreenRoomById(Long id) {
        return screenRoomRepository.findScreenRoomById(id);
    }

    public void updateScreenRoom(@Valid ScreenRoom screenRoom) {
        screenRoomRepository.updateScreenRoom(screenRoom);
    }

    public void deactivateScreenRoom(Long id) {
        screenRoomRepository.deactivateScreenRoom(id);
    }
}