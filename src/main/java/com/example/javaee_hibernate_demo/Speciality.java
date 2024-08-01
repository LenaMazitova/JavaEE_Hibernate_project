package com.example.javaee_hibernate_demo;

import jakarta.persistence.*;

import java.util.List;
@NamedEntityGraph(
        name = "WithCoachesAndAthletes",
        attributeNodes = {
                @NamedAttributeNode(value = "coaches", subgraph = "coaches")
        },
        subgraphs = {@NamedSubgraph(
                name = "coaches",
                attributeNodes = {@NamedAttributeNode("athletes")}
        )
        }
)
@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private List<Coach> coaches;

    public Speciality() {
    }

    public Speciality(int id, String description, List<Coach> coaches) {
        this.id = id;
        this.description = description;
        this.coaches = coaches;
    }

    public Speciality(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Speciality(String description, List<Coach> coaches) {
        this.description = description;
        this.coaches = coaches;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public String toString() {
        return "Speciality [id=" + id + ", description=" + description + "]";
    }
}
