package org.example.controller.dto;

public class SaveMarkDTO {
    private int mark;
    private String surname;

    private String subject;

    public SaveMarkDTO(int mark, String surname, String subject) {
        this.mark = mark;
        this.surname = surname;
        this.subject = subject;
    }

    public SaveMarkDTO() {
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
