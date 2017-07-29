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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "roomCategory")
    @JsonBackReference
    private List<Room> roomList;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Pricing pricing;



    public RoomCategory() {
    }

    public RoomCategory(String name, String description,List<Room> roomList,Pricing pricing) {
        this.name = name;
        this.description = description;
        this.roomList = roomList;
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


}
