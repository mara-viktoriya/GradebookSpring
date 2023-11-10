package org.example.model.entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="mark")
public class MarkEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name="value")
    private int value;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkEntity markEntity = (MarkEntity) o;
        return value == markEntity.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public String toString() {
        return "MarkEntity{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subjectEntity) {
        this.subject = subjectEntity;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity studentEntity) {
        this.student = studentEntity;
    }

    public MarkEntity(UUID id, int value, StudentEntity student, SubjectEntity subject) {
        this.id = id;
        this.value = value;
        this.subject = subject;
        this.student = student;
    }

    public MarkEntity() {

    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
