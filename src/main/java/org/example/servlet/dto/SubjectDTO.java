package org.example.servlet.dto;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;

import java.util.List;
import java.util.Objects;

public class SubjectDTO {
    private Long id;
    private String name;
    private List<StudentEntity> studentEntities;
    private List<MarkEntity> markEntities;

    public SubjectDTO(Long id, String name, List<StudentEntity> studentEntities, List<MarkEntity> markEntities) {
        this.id = id;
        this.name = name;
        this.studentEntities = studentEntities;
        this.markEntities = markEntities;
    }

    public SubjectDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudents() {
        return studentEntities;
    }

    public void setStudents(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    public List<MarkEntity> getMarks() {
        return markEntities;
    }

    public void setMarks(List<MarkEntity> markEntities) {
        this.markEntities = markEntities;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentEntities=" + studentEntities +
                ", markEntities=" + markEntities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDTO)) return false;
        SubjectDTO that = (SubjectDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStudents(), that.getStudents()) && Objects.equals(getMarks(), that.getMarks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStudents(), getMarks());
    }
}
