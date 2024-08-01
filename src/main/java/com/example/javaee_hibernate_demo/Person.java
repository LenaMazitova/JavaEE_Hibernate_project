package com.example.javaee_hibernate_demo;

import jakarta.persistence.*;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="seq_person")
    @SequenceGenerator(name="seq_person",
            sequenceName="person_SEQ", allocationSize=1)
    int id;

    @Column(name="name", length = 50, nullable = false)
    String name;

    @Column(name = "surname", length = 50, nullable = false)
    String surname;

    public Person(int id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
