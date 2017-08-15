package com.zadanie.zadanie2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double pricing;

    public RoomCategory() {
    }

    public RoomCategory(String name, String description, Double pricing) {
        this.name = name;
        this.description = description;
        this.pricing = pricing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricing() {
        return pricing;
    }

    public void setPricing(Double pricing) {
        this.pricing = pricing;
    }
}
