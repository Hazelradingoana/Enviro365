package com.enviro.assessment.grad001.HazelRadingoana.controllers;

import com.enviro.assessment.grad001.HazelRadingoana.model.WasteCategory;
import com.enviro.assessment.grad001.HazelRadingoana.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        System.out.println("Fetching all waste categories");
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return new ResponseEntity<>(wasteCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable("id") Long id) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        if (wasteCategory != null) {
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return new ResponseEntity<>(createdWasteCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(
            @PathVariable("id") Long id,
            @RequestBody WasteCategory updatedWasteCategory
    ) {
        WasteCategory updatedCategory = wasteCategoryService.updateWasteCategory(id, updatedWasteCategory);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable("id") Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
