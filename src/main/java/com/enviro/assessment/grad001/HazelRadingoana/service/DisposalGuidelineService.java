package com.enviro.assessment.grad001.HazelRadingoana.service;

import com.enviro.assessment.grad001.HazelRadingoana.model.DisposalGuideline;
import com.enviro.assessment.grad001.HazelRadingoana.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline disposalGuideline) {
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedDisposalGuideline) {
        Optional<DisposalGuideline> optionalDisposalGuideline = disposalGuidelineRepository.findById(id);
        if (optionalDisposalGuideline.isPresent()) {
            DisposalGuideline existingDisposalGuideline = optionalDisposalGuideline.get();
            existingDisposalGuideline.setCategory(updatedDisposalGuideline.getCategory());
            existingDisposalGuideline.setGuideline(updatedDisposalGuideline.getGuideline());
            return disposalGuidelineRepository.save(existingDisposalGuideline);
        }
        return null;
    }

    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }

    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long id) {
        Optional<DisposalGuideline> optionalDisposalGuideline = disposalGuidelineRepository.findById(id);
        return optionalDisposalGuideline.orElse(null);
    }
}
