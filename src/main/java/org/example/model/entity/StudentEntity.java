package org.example.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity

@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp = "[a-zA-Z]+")
    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "student") // mark??
    private List<MarkEntity> markEntities;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectEntity> subjectEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity studentEntity = (StudentEntity) o;
        return Objects.equals(id, studentEntity.id) && Objects.equals(surname, studentEntity.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", markEntities=" + markEntities +
                ", subjectEntities=" + subjectEntities +
                '}';
    }

    public StudentEntity() {
    }

    public StudentEntity(Long id, String surname, List<MarkEntity> markEntities, List<SubjectEntity> subjectEntities) {
        this.id = id;
        this.surname = surname;
        this.markEntities = markEntities;
        this.subjectEntities = subjectEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<MarkEntity> getMarks() {
        return markEntities;
    }

    public void setMarks(List<MarkEntity> markEntities) {
        this.markEntities = markEntities;
    }

    public List<SubjectEntity> getSubjects() {
        return subjectEntities;
    }

    public void setSubjects(List<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }
}