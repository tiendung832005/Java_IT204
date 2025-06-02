package com.data.session16.controller;


import com.data.session16.DAO.ResumeDAO;
import com.data.session16.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeDAO resumeDAO;

    @GetMapping
    public String listResumes(Model model){
        try{
            model.addAttribute("resumes", resumeDAO.getAllResumes());
        }catch (SQLException e){
            model.addAttribute("error", "Error fetching resumes: " + e.getMessage());
        }
        return "resume-list";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("resume", new Resume());
        return "resume-form";
    }

    @PostMapping
    public String saveResume(@ModelAttribute Resume resume, Model model){
        try{
            resumeDAO.saveResume(resume);
        }catch (SQLException e){
            model.addAttribute("error", "Error saving resume: " + e.getMessage());
            return "resume-form";
        }
        return "redirect:/resume";
    }

    @GetMapping("/delete/{id}")
    public String deleteResume(@PathVariable Long id, Model model){
        try{
            resumeDAO.deleteResume(id);
        }catch (SQLException e){
            model.addAttribute("error", "Error deleting resume: " + e.getMessage());
        }
        return "redirect:/resume";
    }
}
