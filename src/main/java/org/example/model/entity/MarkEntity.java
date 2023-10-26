package org.example.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "mark")
public class MarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Min(2)
    @Max(5)
    @Column(name = "value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subjectEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkEntity markEntity = (MarkEntity) o;
        return value == markEntity.value && Objects.equals(id, markEntity.id);
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
                ", studentEntity=" + studentEntity +
                ", subjectEntity=" + subjectEntity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StudentEntity getStudent() {
        return studentEntity;
    }

    public void setStudent(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public SubjectEntity getSubject() {
        return subjectEntity;
    }

    public void setSubject(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public MarkEntity(Long id, int value, StudentEntity studentEntity, SubjectEntity subjectEntity) {
        this.id = id;
        this.value = value;
        this.studentEntity = studentEntity;
        this.subjectEntity = subjectEntity;
    }

    public MarkEntity() {
    }
}
