package com.data.session19a.controller;

import com.data.session19a.entity.Theater;
import com.data.session19a.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepository;

    @GetMapping
    public String listTheaters(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int size,
                               Model model) {
        List<Theater> theaters = theaterRepository.findAllTheaters(page, size);
        model.addAttribute("theaters", theaters);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "theater-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "theater-form";
    }

    @PostMapping("/add")
    public String addTheater(@Valid @ModelAttribute Theater theater, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theater", theater);
            return "theater-form";
        }
        theaterRepository.saveTheater(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Theater theater = theaterRepository.findTheaterById(id);
        model.addAttribute("theater", theater);
        return "theater-form";
    }

    @PostMapping("/edit")
    public String editTheater(@Valid @ModelAttribute Theater theater, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theater", theater);
            return "theater-form";
        }
        theaterRepository.updateTheater(theater);
        return "redirect:/theaters";
    }

    @PostMapping("/delete/{id}")
    public String deleteTheater(@PathVariable Long id) {
        theaterRepository.deleteTheater(id);
        return "redirect:/theaters";
    }

    @PostMapping("/status/{id}")
    public String setTheaterStatus(@PathVariable Long id, @RequestParam boolean status) {
        theaterRepository.setTheaterStatus(id, status);
        return "redirect:/theaters";
    }
}