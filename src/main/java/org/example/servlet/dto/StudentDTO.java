package org.example.servlet.dto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StudentDTO {
    private UUID id;

    private String surname;

    private List<MarkDTO> markDtoList;

    private List<SubjectDTO> subjectDtoList;

    public StudentDTO() {
        this.id = UUID.randomUUID();
    }

    public StudentDTO(UUID id, String surname, List<MarkDTO> markDtoList, List<SubjectDTO> subjectDtoList) {
        this.id = id;
        this.surname = surname;
        this.markDtoList = markDtoList;
        this.subjectDtoList = subjectDtoList;
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

    public List<MarkDTO> getMarkDtoList() {
        return markDtoList;
    }

    public void setMarkDtoList(List<MarkDTO> markDtoList) {
        this.markDtoList = markDtoList;
    }

    public List<SubjectDTO> getSubjectDtoList() {
        return subjectDtoList;
    }

    public void setSubjectDtoList(List<SubjectDTO> subjectDtoList) {
        this.subjectDtoList = subjectDtoList;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                ", surname='" + surname + '\'' +
                ", markDtoList=" + markDtoList +
                ", subjectDtoList=" + subjectDtoList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getMarkDtoList(), that.getMarkDtoList()) && Objects.equals(getSubjectDtoList(), that.getSubjectDtoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getMarkDtoList(), getSubjectDtoList());
    }
}
