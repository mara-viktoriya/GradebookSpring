package org.example.model.entity;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StudentEntity {


    private UUID id;

    private String surname;

    private List<MarkEntity> markEntityList;

    private List<SubjectEntity> subjectEntityList;

    public StudentEntity() {
        this.id = UUID.randomUUID();
    }

    public StudentEntity(UUID id, String surname, List<MarkEntity> markEntityList, List<SubjectEntity> subjectEntityList) {
        this.id = id;
        this.surname = surname;
        this.markEntityList = markEntityList;
        this.subjectEntityList = subjectEntityList;
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

    public List<MarkEntity> getMarkEntityList() {
        return markEntityList;
    }

    public void setMarkEntityList(List<MarkEntity> markEntityList) {
        this.markEntityList = markEntityList;
    }

    public List<SubjectEntity> getSubjectEntityList() {
        return subjectEntityList;
    }

    public void setSubjectEntityList(List<SubjectEntity> subjectEntityList) {
        this.subjectEntityList = subjectEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getMarkEntityList(), that.getMarkEntityList()) && Objects.equals(getSubjectEntityList(), that.getSubjectEntityList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getMarkEntityList(), getSubjectEntityList());
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", markEntityList=" + markEntityList +
                ", subjectEntityList=" + subjectEntityList +
                '}';
    }
}