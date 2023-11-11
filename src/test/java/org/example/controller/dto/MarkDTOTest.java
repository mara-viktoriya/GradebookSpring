package org.example.controller.dto;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarkDTOTest {


    @Test
    void testToString() {
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);
        MarkDTO mark = new MarkDTO(UUID.randomUUID(), 5, subject, student);

        assertNotNull(mark.toString());
    }

    @Test
    void testGettersAndSetters() {
        UUID id = UUID.randomUUID();
        int value = 5;
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);
        MarkDTO mark = new MarkDTO();

        mark.setId(id);
        mark.setValue(value);
        mark.setSubject(subject);
        mark.setStudent(student);

        assertEquals(id, mark.getId());
        assertEquals(value, mark.getValue());
        assertEquals(subject, mark.getSubject());
        assertEquals(student, mark.getStudent());
    }

    @Test
    void testConstructor() {
        UUID id = UUID.randomUUID();
        int value = 5;
        SubjectDTO subject = Mockito.mock(SubjectDTO.class);
        StudentDTO student = Mockito.mock(StudentDTO.class);

        MarkDTO mark = new MarkDTO(id, value, subject, student);

        assertEquals(id, mark.getId());
        assertEquals(value, mark.getValue());
        assertEquals(subject, mark.getSubject());
        assertEquals(student, mark.getStudent());
    }
}

