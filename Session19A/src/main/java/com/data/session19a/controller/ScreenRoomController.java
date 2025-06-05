package com.data.session19a.controller;

import com.data.session19a.entity.ScreenRoom;
import com.data.session19a.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/screen-rooms")
public class ScreenRoomController {

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String listScreenRooms(Model model) {
        List<ScreenRoom> screenRooms = screenRoomService.findActiveScreenRooms();
        model.addAttribute("screenRooms", screenRooms);
        return "screen-room-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("screenRoom", new ScreenRoom());
        return "screen-room-form";
    }

    @PostMapping("/add")
    public String addScreenRoom(@Valid @ModelAttribute ScreenRoom screenRoom, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("screenRoom", screenRoom);
            return "screen-room-form";
        }
        screenRoomService.createScreenRoom(screenRoom);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ScreenRoom screenRoom = screenRoomService.findScreenRoomById(id);
        model.addAttribute("screenRoom", screenRoom);
        return "screen-room-form";
    }

    @PostMapping("/edit")
    public String editScreenRoom(@Valid @ModelAttribute ScreenRoom screenRoom, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("screenRoom", screenRoom);
            return "screen-room-form";
        }
        screenRoomService.updateScreenRoom(screenRoom);
        return "redirect:/screen-rooms";
    }

    @PostMapping("/delete/{id}")
    public String deactivateScreenRoom(@PathVariable Long id) {
        screenRoomService.deactivateScreenRoom(id);
        return "redirect:/screen-rooms";
    }
}