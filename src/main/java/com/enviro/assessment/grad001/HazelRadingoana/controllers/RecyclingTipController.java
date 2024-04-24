package com.enviro.assessment.grad001.HazelRadingoana.controllers;

import com.enviro.assessment.grad001.HazelRadingoana.model.RecyclingTip;
import com.enviro.assessment.grad001.HazelRadingoana.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return new ResponseEntity<>(recyclingTips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable("id") Long id) {
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        if (recyclingTip != null) {
            return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return new ResponseEntity<>(createdRecyclingTip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(
            @PathVariable("id") Long id,
            @RequestBody RecyclingTip updatedRecyclingTip
    ) {
        RecyclingTip updatedTip = recyclingTipService.updateRecyclingTip(id, updatedRecyclingTip);
        if (updatedTip != null) {
            return new ResponseEntity<>(updatedTip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable("id") Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
