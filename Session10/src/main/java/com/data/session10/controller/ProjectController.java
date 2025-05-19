package com.data.session10.controller;

import com.data.session10.model.Project;
import com.data.session10.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    private static final String UPLOAD_DIR = "project-documents/";

    @PostMapping("/createProject")
    public String createProject(@RequestParam("name") String name,
                                @RequestParam("description") String description,
                                @RequestParam("documents") List<MultipartFile> documents,
                                Model model) {
        List<Document> documentList = new ArrayList<>();
        for (MultipartFile file : documents) {
            if (!file.isEmpty()) {
                try {
                    String filePath = UPLOAD_DIR + file.getOriginalFilename();
                    File destinationFile = new File(filePath);
                    destinationFile.getParentFile().mkdirs();
                    file.transferTo(destinationFile);

                    documentList.add(new Document(file.getOriginalFilename(), "Uploaded document", filePath));
                } catch (IOException e) {
                    model.addAttribute("message", "Failed to upload document: " + e.getMessage());
                    return "projectResult";
                }
            }
        }

        Project project = new Project(name, description, documentList);

        model.addAttribute("project", project);
        model.addAttribute("message", "Project created successfully!");
        return "projectResult";
    }

    @PostMapping("/updateProject")
    public String updateProject(@RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("description") String description,
                                Model model) {

        model.addAttribute("message", "Project updated successfully!");
        return "projectResult";
    }

    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("id") Long id, Model model) {
        model.addAttribute("message", "Project deleted successfully!");
        return "projectResult";
    }
}
