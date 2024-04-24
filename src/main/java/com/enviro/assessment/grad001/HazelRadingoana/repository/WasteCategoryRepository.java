package com.enviro.assessment.grad001.HazelRadingoana.repository;

import com.enviro.assessment.grad001.HazelRadingoana.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory,Long> {

}
