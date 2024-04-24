package com.enviro.assessment.grad001.HazelRadingoana.service;

import com.enviro.assessment.grad001.HazelRadingoana.model.WasteCategory;
import com.enviro.assessment.grad001.HazelRadingoana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedWasteCategory) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);
        if (optionalWasteCategory.isPresent()) {
            WasteCategory existingWasteCategory = optionalWasteCategory.get();
            existingWasteCategory.setName(updatedWasteCategory.getName());
            existingWasteCategory.setDescription(updatedWasteCategory.getDescription());
            return wasteCategoryRepository.save(existingWasteCategory);
        }
        return null;
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }

    public List<WasteCategory> getAllWasteCategories() {
        System.out.println(wasteCategoryRepository.findAll());
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);
        return optionalWasteCategory.orElse(null);
    }



}
