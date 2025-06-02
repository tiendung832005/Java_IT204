package com.data.session16a.controller;

import com.data.session16a.model.Bus;
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
@RequestMapping("/admin/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public String listBuses(Model model, HttpSession session) {
        checkAdmin(session);
        model.addAttribute("buses", busService.findAll());
        return "bus/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus/add";
    }

    @PostMapping("/add")
    public String addBus(@Valid @ModelAttribute Bus bus, BindingResult result) {
        if (result.hasErrors()) return "bus/add";
        busService.addBus(bus);
        return "redirect:/admin/bus";
    }

    private void checkAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) throw new RuntimeException("Unauthorized");
    }
}
