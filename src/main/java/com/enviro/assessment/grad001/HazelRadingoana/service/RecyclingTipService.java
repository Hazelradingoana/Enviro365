package com.enviro.assessment.grad001.HazelRadingoana.service;

import com.enviro.assessment.grad001.HazelRadingoana.model.RecyclingTip;
import com.enviro.assessment.grad001.HazelRadingoana.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;

    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedRecyclingTip) {
        Optional<RecyclingTip> optionalRecyclingTip = recyclingTipRepository.findById(id);
        if (optionalRecyclingTip.isPresent()) {
            RecyclingTip existingRecyclingTip = optionalRecyclingTip.get();
            existingRecyclingTip.setTitle(updatedRecyclingTip.getTitle());
            existingRecyclingTip.setDescription(updatedRecyclingTip.getDescription());
            return recyclingTipRepository.save(existingRecyclingTip);
        }
        return null;
    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }

    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long id) {
        Optional<RecyclingTip> optionalRecyclingTip = recyclingTipRepository.findById(id);
        return optionalRecyclingTip.orElse(null);
    }
}
