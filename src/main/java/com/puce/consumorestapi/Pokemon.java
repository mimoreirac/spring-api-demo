package com.puce.consumorestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {

    @Id
    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;

    @JsonProperty("base_experience")
    private Integer baseExperience;

    public Pokemon() {}

    public Pokemon(Integer id, String name, Integer height, Integer weight, Integer baseExperience) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExperience = baseExperience;

    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getHeight() { return height; }
    public void setHeight(Integer height) { this.height = height; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public Integer getBaseExperience() { return baseExperience; }
    public void setBaseExperience(Integer baseExperience) { this.baseExperience = baseExperience; }
}
