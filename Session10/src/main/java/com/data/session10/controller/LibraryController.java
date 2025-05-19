package com.data.session10.controller;

import com.data.session10.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class LibraryController {

    private static final String UPLOAD_DIR = "library-books/";

    @PostMapping("/addBook")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("description") String description,
                          @RequestParam("file") MultipartFile file,
                          Model model) {
        if (!file.isEmpty()) {
            try {
                String filePath = UPLOAD_DIR + file.getOriginalFilename();
                File destinationFile = new File(filePath);
                destinationFile.getParentFile().mkdirs();
                file.transferTo(destinationFile);

                Book book = new Book(title, author, description, file.getOriginalFilename());


                model.addAttribute("book", book);
                model.addAttribute("message", "Book added successfully!");
            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload file: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Please upload a file.");
        }
        return "bookResult";
    }

    @PostMapping("/editBook")
    public String editBook(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("description") String description,
                           Model model) {
        model.addAttribute("message", "Book updated successfully!");
        return "bookResult";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") Long id, Model model) {
        model.addAttribute("message", "Book deleted successfully!");
        return "bookResult";
    }
}
