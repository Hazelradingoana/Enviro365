package com.enviro.assessment.grad001.HazelRadingoana.controllers;

import com.enviro.assessment.grad001.HazelRadingoana.model.DisposalGuideline;
import com.enviro.assessment.grad001.HazelRadingoana.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return new ResponseEntity<>(disposalGuidelines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable("id") Long id) {
        DisposalGuideline disposalGuideline = disposalGuidelineService.getDisposalGuidelineById(id);
        if (disposalGuideline != null) {
            return new ResponseEntity<>(disposalGuideline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdDisposalGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuideline);
        return new ResponseEntity<>(createdDisposalGuideline, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @PathVariable("id") Long id,
            @RequestBody DisposalGuideline updatedDisposalGuideline
    ) {
        DisposalGuideline updatedGuideline = disposalGuidelineService.updateDisposalGuideline(id, updatedDisposalGuideline);
        if (updatedGuideline != null) {
            return new ResponseEntity<>(updatedGuideline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable("id") Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


