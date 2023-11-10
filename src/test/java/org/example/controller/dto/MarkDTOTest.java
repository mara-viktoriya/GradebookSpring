package org.example.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

public class MarkDTOTest {


    @Test
    void testToString() {
        // Arrange
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);
        MarkDTO mark = new MarkDTO(UUID.randomUUID(), 90, subject, student);

        // Act & Assert
        assertNotNull(mark.toString());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        UUID id = UUID.randomUUID();
        int value = 85;
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);
        MarkDTO mark = new MarkDTO();

        // Act
        mark.setId(id);
        mark.setValue(value);
        mark.setSubject(subject);
        mark.setStudent(student);

        // Assert
        assertEquals(id, mark.getId());
        assertEquals(value, mark.getValue());
        assertEquals(subject, mark.getSubject());
        assertEquals(student, mark.getStudent());
    }

    @Test
    void testConstructor() {
        // Arrange
        UUID id = UUID.randomUUID();
        int value = 90;
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);

        // Act
        MarkDTO mark = new MarkDTO(id, value, subject, student);

        // Assert
        assertEquals(id, mark.getId());
        assertEquals(value, mark.getValue());
        assertEquals(subject, mark.getSubject());
        assertEquals(student, mark.getStudent());
    }
}

