package com.enviro.assessment.grad001.HazelRadingoana.model;

import javax.persistence.*;

@Entity
@Table(name = "disposal_guideline")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long category;

    @Column(nullable = false)
    private String guideline;

    public DisposalGuideline(){

    }


    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getCategory() {
        return category;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public String getGuideline() {
        return guideline;
    }
}
