package org.example.controller.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDTOTest {

    @Test
    void testGettersAndSetters() {
        UUID id = UUID.randomUUID();
        String surname = "Johnson";
        StudentDTO student = new StudentDTO();

        student.setId(id);
        student.setSurname(surname);

        assertEquals(id, student.getId());
        assertEquals(surname, student.getSurname());
    }

    @Test
    void testConstructor() {
        UUID id = UUID.randomUUID();
        String surname = "Johnson";

        StudentDTO student = new StudentDTO(id, surname);

        assertEquals(id, student.getId());
        assertEquals(surname, student.getSurname());
    }
}
