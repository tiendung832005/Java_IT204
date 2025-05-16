package com.data.session09.Controller;

import com.data.session09.model.Seat;
import com.data.session09.model.Ticket;
import com.data.session09.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/bookTicket")
    public String bookTicket(@RequestParam("scheduleId") Long scheduleId, Model model) {
        // Mock data for seats and schedule details
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Seat seat = new Seat();
            seat.setId((long) i);
            seat.setScreenRoomId(1L);
            seat.setStatus(i % 2 == 0 ? "Booked" : "Available");
            seats.add(seat);
        }
        model.addAttribute("seats", seats);
        model.addAttribute("scheduleId", scheduleId);
        return "bookTicket";
    }

    @PostMapping("/confirmBooking")
    public String confirmBooking(@RequestParam("scheduleId") Long scheduleId,
                                 @RequestParam("selectedSeats") List<Long> selectedSeats,
                                 Model model) {

        double totalMoney = selectedSeats.size() * 50000.0;


        Ticket ticket = new Ticket();
        ticket.setCustomerId(1L); // Mock customer ID
        ticket.setScheduleId(scheduleId);
        ticket.setTotalMoney(totalMoney);
        ticket.setCreatedAt(new Date());

        ticketService.addTicket(ticket);

        model.addAttribute("totalMoney", totalMoney);
        return "bookingSuccess";
    }
}
