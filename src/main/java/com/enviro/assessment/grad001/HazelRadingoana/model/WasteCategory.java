package com.enviro.assessment.grad001.HazelRadingoana.model;


import javax.persistence.*;

@Entity
@Table(name = "waste_category")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  String  description;


    public WasteCategory(){

    }

    public WasteCategory(String name, String description){
        this.name = name;
        this.description = description;

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WasteCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
