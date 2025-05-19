package com.data.session10.controller;

import com.data.session10.model.Ticket;
import com.data.session10.model.Seat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestParam("movieTitle") String movieTitle,
                             @RequestParam("showTime") String showTime,
                             @RequestParam("seats") List<String> seatNumbers,
                             @RequestParam("totalAmount") double totalAmount,
                             Model model) {
        try {
            Date parsedShowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(showTime);

            List<Seat> seats = new ArrayList<>();
            for (String seatNumber : seatNumbers) {
                seats.add(new Seat(seatNumber));
            }

            Ticket ticket = new Ticket(movieTitle, parsedShowTime, seats, totalAmount);

            model.addAttribute("ticket", ticket);
            model.addAttribute("message", "Booking successful!");

        } catch (ParseException e) {
            model.addAttribute("message", "Invalid show time format. Please use 'yyyy-MM-dd HH:mm'.");
        }

        return "bookingResult";
    }
}
