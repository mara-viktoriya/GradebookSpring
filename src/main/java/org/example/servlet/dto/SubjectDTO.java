package org.example.servlet.dto;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SubjectDTO {
    private UUID id;
    private String name;
    private List<StudentDTO> studentDTOList;
    private List<MarkDTO> markDTOList;
    public SubjectDTO() {
        this.id = UUID.randomUUID();
    }

    public SubjectDTO(UUID id, String name, List<StudentDTO> studentDTOList, List<MarkDTO> markDTOList) {
        this.id = id;
        this.name = name;
        this.studentDTOList = studentDTOList;
        this.markDTOList = markDTOList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDTO> getStudentDTOList() {
        return studentDTOList;
    }

    public void setStudentDTOList(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }

    public List<MarkDTO> getMarkDTOList() {
        return markDTOList;
    }

    public void setMarkDTOList(List<MarkDTO> markDTOList) {
        this.markDTOList = markDTOList;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentDTOList=" + studentDTOList +
                ", markDTOList=" + markDTOList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStudentDTOList(), that.getStudentDTOList()) && Objects.equals(getMarkDTOList(), that.getMarkDTOList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStudentDTOList(), getMarkDTOList());
    }
}
