package com.data.session16a.controller;

import com.data.session16a.model.BusTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.jvm.hotspot.debugger.Page;

@Controller
public class TripController {

    @Autowired
    private BusTripService busTripService;

    @GetMapping("/home")
    public String viewTrips(@RequestParam(defaultValue = "") String departure,
                            @RequestParam(defaultValue = "") String destination,
                            @RequestParam(defaultValue = "0") int page,
                            Model model) {
        Page<BusTrip> trips = busTripService.searchTrips(departure, destination, page);
        model.addAttribute("trips", trips);
        return "home";
    }
}
