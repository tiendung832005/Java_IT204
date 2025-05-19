package com.data.session10.controller;

import com.data.session10.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@RequestParam("username") String username,
                               @RequestParam("avatar") MultipartFile avatar,
                               Model model) {
        if (!avatar.isEmpty()) {
            try {
                String filePath = UPLOAD_DIR + avatar.getOriginalFilename();
                File file = new File(filePath);
                file.getParentFile().mkdirs(); // Ensure the directory exists
                avatar.transferTo(file);

                UserProfile userProfile = new UserProfile(username, avatar.getOriginalFilename());

                model.addAttribute("userProfile", userProfile);
                model.addAttribute("message", "Avatar uploaded successfully!");

            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload avatar: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Please select a file to upload.");
        }

        return "uploadResult";
    }
}
