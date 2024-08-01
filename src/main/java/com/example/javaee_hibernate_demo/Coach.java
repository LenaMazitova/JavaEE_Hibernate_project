package com.example.javaee_hibernate_demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@NamedEntityGraph(
        name = "WithAthletes",
        attributeNodes = { @NamedAttributeNode("athletes") }
)
@Entity
@Table(name = "coach")
public class Coach extends Person {
    @Column(name = "status")
    int status;
    @ManyToMany
    @JoinTable(name = "coach_speciality",
            joinColumns = {@JoinColumn(name = "coach_id")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
    private List<Speciality> specialities;

    @OneToMany(mappedBy = "coach")
    private List<Athlete> athletes;

    public Coach() {
    }

    public Coach(int id, int status, List<Speciality> specialities, List<Athlete> athletes) {
        super(id);
        this.status = status;
        this.specialities = specialities;
        this.athletes = athletes;
    }

    public Coach(int status, List<Speciality> specialities, List<Athlete> athletes) {
        this.status = status;
        this.specialities = specialities;
        this.athletes = athletes;
    }

    public Coach(int id, String name, String surname, int status, List<Speciality> specialities, List<Athlete> athletes) {
        super(id, name, surname);
        this.status = status;
        this.specialities = specialities;
        this.athletes = athletes;
    }

    public Coach(String name, String surname, int status, List<Speciality> specialities, List<Athlete> athletes) {
        super(name, surname);
        this.status = status;
        this.specialities = specialities;
        this.athletes = athletes;
    }

    public void addAthlete(Athlete athlete) {
        if (athletes == null) {
            athletes = new ArrayList<Athlete>();
        }
        athletes.add(athlete);
        athlete.addCoach(this);
    }

    public void addSpeciality(Speciality speciality) {
        if (specialities == null) {
            specialities = new ArrayList<Speciality>();
        }
        specialities.add(speciality);
        speciality.getCoaches().add(this);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    @Override
    public String toString() {
        return "Coach{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status=" + status +
                '}';
    }
}