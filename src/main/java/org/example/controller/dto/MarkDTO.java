package org.example.controller.dto;

import java.util.UUID;


public class MarkDTO {

    private UUID id;

    private int value;

    private SubjectDTO subject;

    private StudentDTO student;
    public MarkDTO() {

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
