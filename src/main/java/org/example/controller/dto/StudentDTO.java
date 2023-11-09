package org.example.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public class StudentDTO {



    @NotNull
    private UUID id;

    @NotBlank
    private String surname;


    public StudentDTO() {
    }

    public StudentDTO(UUID id, String surname) {
        this.id = id;
        this.surname = surname;
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

}
