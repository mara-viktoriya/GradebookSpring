package org.example.controller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.UUID;

public class StudentDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        UUID id = UUID.randomUUID();
        String surname = "Johnson";
        StudentDTO student = new StudentDTO();

        // Act
        student.setId(id);
        student.setSurname(surname);

        // Assert
        assertEquals(id, student.getId());
        assertEquals(surname, student.getSurname());
    }

    @Test
    void testConstructor() {
        // Arrange
        UUID id = UUID.randomUUID();
        String surname = "Johnson";

        // Act
        StudentDTO student = new StudentDTO(id, surname);

        // Assert
        assertEquals(id, student.getId());
        assertEquals(surname, student.getSurname());
    }
}
