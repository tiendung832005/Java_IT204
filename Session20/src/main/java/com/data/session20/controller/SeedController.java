package com.data.session20.controller;

import com.data.session20.entity.Seed;
import com.data.session20.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/seeds")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("seed", new Seed());
        return "add-seed";
    }

    @PostMapping("/add")
    public String addSeed(@Valid @ModelAttribute("seed") Seed seed,
                          BindingResult result,
                          @RequestParam("imageFile") MultipartFile imageFile,
                          Model model) {
        if (result.hasErrors()) {
            return "add-seed";
        }

        if (!seedService.isSeedNameUnique(seed.getSeedName())) {
            model.addAttribute("nameError", "Seed name must be unique");
            return "add-seed";
        }

        String imageUrl = seedService.uploadImageToCloudinary(imageFile);
        if (imageUrl == null) {
            model.addAttribute("imageError", "Invalid image format");
            return "add-seed";
        }

        seed.setImage(imageUrl);
        seedService.saveSeed(seed);
        return "redirect:/seeds/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Seed seed = seedService.findById(id);
        if (seed == null) {
            return "redirect:/seeds/list";
        }
        model.addAttribute("seed", seed);
        return "edit-seed";
    }

    @PostMapping("/edit/{id}")
    public String updateSeed(@PathVariable("id") Integer id,
                             @Valid @ModelAttribute("seed") Seed seed,
                             BindingResult result,
                             @RequestParam("imageFile") MultipartFile imageFile,
                             Model model) {
        if (result.hasErrors()) {
            return "edit-seed";
        }

        if (!seedService.isSeedNameUniqueForUpdate(seed.getSeedName(), id)) {
            model.addAttribute("nameError", "Seed name must be unique");
            return "edit-seed";
        }

        if (!imageFile.isEmpty()) {
            String imageUrl = seedService.uploadImageToCloudinary(imageFile);
            if (imageUrl == null) {
                model.addAttribute("imageError", "Invalid image format");
                return "edit-seed";
            }
            seed.setImage(imageUrl);
        }

        seedService.updateSeed(id, seed);
        return "redirect:/seeds/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeed(@PathVariable("id") Integer id) {
        seedService.deleteSeed(id);
        return "redirect:/seeds/list";
    }

    @GetMapping("/list")
    public String listSeeds(Model model) {
        model.addAttribute("seeds", seedService.findAll());
        return "seed-list";
    }

    @GetMapping("/search")
    public String searchSeeds(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "minPrice", required = false) Double minPrice,
                              @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                              Model model) {
        model.addAttribute("seeds", seedService.searchSeeds(name, minPrice, maxPrice));
        return "seed-list";
    }
}