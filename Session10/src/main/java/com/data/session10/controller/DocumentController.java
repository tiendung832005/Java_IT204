package com.data.session10.controller;

import com.data.session10.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class DocumentController {

    private static final String UPLOAD_DIR = "documents/";

    @PostMapping("/uploadDocument")
    public String uploadDocument(@RequestParam("title") String title,
                                 @RequestParam("description") String description,
                                 @RequestParam("file") MultipartFile file,
                                 Model model) {
        if (!file.isEmpty() && file.getOriginalFilename().endsWith(".pdf")) {
            try {
                String filePath = UPLOAD_DIR + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);


                Document document = new Document(title, description, file.getOriginalFilename());


                model.addAttribute("document", document);
                model.addAttribute("message", "Document uploaded successfully!");

            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload document: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Please upload a valid PDF file.");
        }

        return "documentResult";
    }
}
