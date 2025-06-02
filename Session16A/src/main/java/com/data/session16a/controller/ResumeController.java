package com.data.session16a.controller;


import com.data.session16a.DAO.ResumeDAO;
import com.data.session16a.model.Resume;
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


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Resume resume = resumeDAO.getResumeById(id);
            model.addAttribute("resume", resume);
            return "resume-form";
        } catch (SQLException e) {
            model.addAttribute("error", "Lỗi khi lấy resume: " + e.getMessage());
            return "redirect:/resume";
        }
    }

    @PostMapping("/update/{id}")
    public String updateResume(@PathVariable Long id, @ModelAttribute Resume resume, Model model) {
        try {
            resume.setId(id);
            resumeDAO.updateResume(resume);
        } catch (SQLException e) {
            model.addAttribute("error", "Lỗi khi update: " + e.getMessage());
            return "resume-form";
        }
        return "redirect:/resume";
    }

    @PostMapping
    public String saveOrUpdateResume(@ModelAttribute Resume resume, Model model){
        try{
            if(resume.getId() == null){
                // insert mới
                resumeDAO.saveResume(resume);
            } else {
                // update bản ghi đã có
                resumeDAO.updateResume(resume);
            }
        } catch (SQLException e){
            model.addAttribute("error", "Lỗi khi lưu: " + e.getMessage());
            return "resume-form";
        }
        return "redirect:/resume";
    }


    @GetMapping("/delete/{id}")
    public String deleteResume(@PathVariable Long id, Model model){
        try{
            resumeDAO.deleteResume(id);
        }catch (SQLException e){
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
        }
        return "redirect:/resume";
    }
}
