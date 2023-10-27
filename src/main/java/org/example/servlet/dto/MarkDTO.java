package org.example.servlet.dto;


import org.example.model.entity.SubjectEntity;

import java.util.Objects;
import java.util.UUID;

public class MarkDTO {
    private UUID id;
    private int value;
    private SubjectDTO subjectDto;

    private StudentDTO studentDTO;
    public MarkDTO() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkDTO markDTO)) return false;
        return getValue() == markDTO.getValue() && Objects.equals(getId(), markDTO.getId()) && Objects.equals(getSubjectDto(), markDTO.getSubjectDto()) && Objects.equals(getStudentDTO(), markDTO.getStudentDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getSubjectDto(), getStudentDTO());
    }

    @Override
    public String toString() {
        return "MarkDTO{" +
                "id=" + id +
                ", value=" + value +
                ", subjectDto=" + subjectDto +
                ", studentDTO=" + studentDTO +
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

    public SubjectDTO getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDTO subjectDto) {
        this.subjectDto = subjectDto;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public MarkDTO(UUID id, int value, SubjectDTO subjectDto, StudentDTO studentDTO) {
        this.id = id;
        this.value = value;
        this.subjectDto = subjectDto;
        this.studentDTO = studentDTO;
    }
}
