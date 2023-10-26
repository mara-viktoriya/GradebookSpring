package org.example.servlet.dto;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.SubjectEntity;

import java.util.List;
import java.util.Objects;

public class StudentDTO {
    private Long id;

    private String surname;


    private List<MarkEntity> markEntities;

    private List<SubjectEntity> subjectEntities;

    public StudentDTO(Long id, String surname, List<MarkEntity> markEntities, List<SubjectEntity> subjectEntities) {
        this.id = id;
        this.surname = surname;
        this.markEntities = markEntities;
        this.subjectEntities = subjectEntities;
    }

    public StudentDTO() {
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", markEntities=" + markEntities +
                ", subjectEntities=" + subjectEntities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO)) return false;
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getMarks(), that.getMarks()) && Objects.equals(getSubjects(), that.getSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getMarks(), getSubjects());
    }
}
