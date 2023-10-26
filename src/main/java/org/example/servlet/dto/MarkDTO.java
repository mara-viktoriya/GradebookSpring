package org.example.servlet.dto;


import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;

import java.util.Objects;

public class MarkDTO {
    private Long id;
    private int value;

    private StudentEntity studentEntity;

    private SubjectEntity subjectEntity;

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

    public MarkDTO(Long id, int value, StudentEntity studentEntity, SubjectEntity subjectEntity) {
        this.id = id;
        this.value = value;
        this.studentEntity = studentEntity;
        this.subjectEntity = subjectEntity;
    }

    public MarkDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkDTO)) return false;
        MarkDTO markDTO = (MarkDTO) o;
        return getValue() == markDTO.getValue() && Objects.equals(getId(), markDTO.getId()) && Objects.equals(getStudent(), markDTO.getStudent()) && Objects.equals(getSubject(), markDTO.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getStudent(), getSubject());
    }

    @Override
    public String toString() {
        return "MarkDTO{" +
                "id=" + id +
                ", value=" + value +
                ", studentEntity=" + studentEntity +
                ", subjectEntity=" + subjectEntity +
                '}';
    }
}
