package org.example.model.entity;


import java.util.Objects;
import java.util.UUID;

public class MarkEntity {


    private UUID id;

    private int value;

    private SubjectEntity subjectEntity;

    private StudentEntity studentEntity;

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
                ", subjectEntity=" + subjectEntity +
                ", studentEntity=" + studentEntity +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public MarkEntity(UUID id, int value, StudentEntity studentEntity, SubjectEntity subjectEntity) {
        this.id = id;
        this.value = value;
        this.subjectEntity = subjectEntity;
        this.studentEntity=studentEntity;
    }

    public MarkEntity() {
        this.id = UUID.randomUUID();
    }
}
