package com.zadanie.zadanie2.dto;

import com.zadanie.zadanie2.model.RoomCategory;

import java.util.ArrayList;
import java.util.List;

public class RoomCategoryDTO {
    private Long id;
    private String name;
    private String description;
    private Double pricing;
    private List<RoomCategory> roomCategories = new ArrayList<>();

    public RoomCategoryDTO(List<RoomCategory> roomCategories) {
        this.roomCategories = roomCategories;
    }
    public RoomCategoryDTO(RoomCategory roomCategory){
        this.name = roomCategory.getName();
        this.description = roomCategory.getDescription();
        this.pricing = roomCategory.getPricing();
    }

    public RoomCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPricing() {
        return pricing;
    }

    public List<RoomCategory> getRoomCategories() {
        return roomCategories;
    }
}
