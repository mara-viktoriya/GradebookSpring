package org.example.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;


public class MarkDTO {

    @JsonProperty(value = "id", required = true)
    @NotNull
    private UUID id;
    @JsonProperty(value = "value", required = true)
    @Min(1)
    @Max(5)
    private int value;
    @JsonProperty(value = "subject", required = true)
    @NotNull
    @Valid
    private SubjectDTO subject;
    @JsonProperty(value = "student", required = true)
    @NotNull
    @Valid
    private StudentDTO student;
    public MarkDTO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkDTO markDTO)) return false;
        return getValue() == markDTO.getValue() && Objects.equals(getSubject(), markDTO.getSubject()) && Objects.equals(getStudent(), markDTO.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getSubject(), getStudent());
    }

    @Override
    public String toString() {
        return "MarkDTO{" +
                ", value=" + value +
                ", subjectDto=" + subject +
                ", studentDTO=" + student +
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

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public MarkDTO(UUID id, int value, SubjectDTO subject, StudentDTO student) {
        this.id = id;
        this.value = value;
        this.subject = subject;
        this.student = student;
    }
}
