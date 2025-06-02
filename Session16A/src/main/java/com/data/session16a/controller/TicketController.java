package com.data.session16a.controller;

import com.data.session16a.model.BusTrip;
import com.data.session16a.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/book/{tripId}")
    public String showBooking(@PathVariable Long tripId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        BusTrip trip = ticketService.getTrip(tripId);
        model.addAttribute("trip", trip);
        return "ticket/book";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam Long tripId, @RequestParam List<String> seats, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        ticketService.bookTicket(user, tripId, seats);
        return "redirect:/home";
    }
}
