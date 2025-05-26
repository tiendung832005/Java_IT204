package com.data.session12.controller;


import com.data.session12.model.Bus;
import com.data.session12.service.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/buses")
public class BusController {
    private final BusService busService = new BusService();

    @GetMapping
    public String listBuses(Model model) throws SQLException {
        model.addAttribute("buses", busService.findAll());
        return "bus_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus_form";
    }

    @PostMapping("/add")
    public String addBus(@Valid @ModelAttribute("bus") Bus bus) throws SQLException {
        busService.save(bus);
        return "redirect:/buses";
    }

    @GetMapping("/delete/{id}")
    public String deleteBus(@PathVariable int id) throws SQLException {
        busService.deleteById(id);
        return "redirect:/buses";
    }
}