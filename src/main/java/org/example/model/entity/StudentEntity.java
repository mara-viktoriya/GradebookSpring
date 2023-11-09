package org.example.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "surname")
    private String surname;

    public StudentEntity() {
    }

    public StudentEntity(UUID id, String surname, List<SubjectEntity> subjectList) {
        this.id = id;
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getSurname(), that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname());
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "surname='" + surname + '\'' +
                '}';
    }
}