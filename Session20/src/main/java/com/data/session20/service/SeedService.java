package com.data.session20.service;

import com.data.session20.entity.Seed;
import com.data.session20.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@Service
public class SeedService {

    @Autowired
    private SeedRepository seedRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    public boolean isSeedNameUnique(String seedName) {
        Seed existingSeed = seedRepository.findBySeedNameIgnoreCase(seedName);
        return existingSeed == null;
    }

    public boolean isSeedNameUniqueForUpdate(String seedName, Integer id) {
        Seed existingSeed = seedRepository.findBySeedNameIgnoreCase(seedName);
        return existingSeed == null || existingSeed.getId().equals(id);
    }

    public String uploadImageToCloudinary(MultipartFile imageFile) {
        try {
            return cloudinaryService.uploadImage(imageFile); // Upload image and return URL
        } catch (Exception e) {
            return null; // Return null if upload fails
        }
    }

    public void saveSeed(Seed seed) {
        seedRepository.save(seed);
    }

    public void updateSeed(Integer id, Seed seed) {
        Seed existingSeed = seedRepository.findById(id);
        if (existingSeed != null) {
            existingSeed.setSeedName(seed.getSeedName());
            existingSeed.setDescription(seed.getDescription());
            existingSeed.setPrice(seed.getPrice());
            existingSeed.setStock(seed.getStock());
            existingSeed.setImage(seed.getImage());
            seedRepository.update(existingSeed);
        }
    }

    public void deleteSeed(Integer id) {
        seedRepository.delete(id);
    }

    public List<Seed> findAll() {
        List<Seed> seeds = seedRepository.findAll();
        return seeds != null ? seeds : new ArrayList<>();
    }

    public List<Seed> searchSeeds(String name, Double minPrice, Double maxPrice) {
        List<Seed> seeds = seedRepository.findAll();
        List<Seed> filteredSeeds = new ArrayList<>();

        for (Seed seed : seeds) {
            boolean matchesName = name == null || seed.getSeedName().toLowerCase().contains(name.toLowerCase());
            boolean matchesPrice = (minPrice == null || seed.getPrice() >= minPrice) &&
                    (maxPrice == null || seed.getPrice() <= maxPrice);

            if (matchesName && matchesPrice) {
                filteredSeeds.add(seed);
            }
        }

        return filteredSeeds;
    }

    public Seed findById(Integer id) {
        return seedRepository.findById(id);
    }
}
