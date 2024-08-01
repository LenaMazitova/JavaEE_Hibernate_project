package com.example.javaee_hibernate_demo;

import jakarta.persistence.*;

@NamedEntityGraph(
        name = "WithCoacheAndSpecialitiesById",
        attributeNodes = { @NamedAttributeNode("coach") }
)
@NamedEntityGraph(
        name = "WithCoacheAndSpecialities",
        attributeNodes = {
                @NamedAttributeNode(value = "coach", subgraph = "specialities")
        },
        subgraphs = {@NamedSubgraph(
                name = "specialities",
                attributeNodes = {@NamedAttributeNode("specialities")}
        )
        }
)
@Entity
@Table(name = "athlete")
public class Athlete extends Person {

    @Column(name = "coach_id")
    int coach_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coach_id", insertable = false, updatable = false)
    private Coach coach;

    public Athlete() {
    }

    public Athlete(int id, int coach_id, Coach coach) {
        super(id);
        this.coach_id = coach_id;
        this.coach = coach;
    }

    public Athlete(int coach_id, Coach coach) {
        this.coach_id = coach_id;
        this.coach = coach;
    }

    public Athlete(int id, String name, String surname, int coach_id, Coach coach) {
        super(id, name, surname);
        this.coach_id = coach_id;
        this.coach = coach;
    }

    public Athlete(String name, String surname, int coach_id, Coach coach) {
        super(name, surname);
        this.coach_id = coach_id;
        this.coach = coach;
    }

    public void addCoach(Coach coach) {
        int id = coach.getId();
        this.coach_id = id;
        this.coach = coach;
        coach.getAthletes().add(this);
    }
    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }


    public Coach getCoach() {
        return coach;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
