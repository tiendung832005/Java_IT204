package com.data.session10.controller;

import com.data.session10.model.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("description") String description,
                             Model model) {
        if (!file.isEmpty()) {
            try {
                String cloudUrl = uploadToCloud(file);

                UploadFile uploadFile = new UploadFile(file.getOriginalFilename(), description, cloudUrl);

                model.addAttribute("uploadFile", uploadFile);
                model.addAttribute("message", "File uploaded successfully!");

            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload file: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Please select a file to upload.");
        }

        return "uploadResult";
    }

    private String uploadToCloud(MultipartFile file) throws IOException {
        return "https://cloud-storage.com/" + file.getOriginalFilename();
    }
}
