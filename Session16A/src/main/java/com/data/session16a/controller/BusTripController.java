package com.data.session16a.controller;

import com.data.session16a.model.BusTrip;
import com.data.session16a.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/bustrip")
public class BusTripController {

    @Autowired
    private BusTripService busTripService;

    @GetMapping
    public String listTrips(Model model, HttpSession session) {
        checkAdmin(session);
        model.addAttribute("trips", busTripService.findAll());
        return "bustrip/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("trip", new BusTrip());
        return "bustrip/add";
    }

    @PostMapping("/add")
    public String addTrip(@Valid @ModelAttribute BusTrip trip, BindingResult result) {
        if (result.hasErrors()) return "bustrip/add";
        busTripService.addTrip(trip);
        return "redirect:/admin/bustrip";
    }

    private void checkAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) throw new RuntimeException("Unauthorized");
    }
}
