package org.example.servlet.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MarkDTOTest {

    @Test
    void testEmptyConstructor() {
        MarkDTO markDTO = new MarkDTO();

        assertNotNull(markDTO.getId()); // ID должен быть сгенерирован
        assertEquals(0, markDTO.getValue());
        assertNull(markDTO.getSubjectDto());
        assertNull(markDTO.getStudentDTO());
    }

    @Test
    void testParameterizedConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        int value = 85;
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        MarkDTO markDTO = new MarkDTO(id, value, subjectDTO, studentDTO);

        assertEquals(id, markDTO.getId());
        assertEquals(value, markDTO.getValue());
        assertEquals(subjectDTO, markDTO.getSubjectDto());
        assertEquals(studentDTO, markDTO.getStudentDTO());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        MarkDTO markDTO1 = new MarkDTO(id1, 85, subjectDTO, studentDTO);
        MarkDTO markDTO2 = new MarkDTO(id1, 85, subjectDTO, studentDTO);
        MarkDTO markDTO3 = new MarkDTO(id2, 90, subjectDTO, studentDTO);

        assertTrue(markDTO1.equals(markDTO2));
        assertTrue(markDTO2.equals(markDTO1));
        assertFalse(markDTO1.equals(markDTO3));
        assertFalse(markDTO3.equals(markDTO1));

        assertEquals(markDTO1.hashCode(), markDTO2.hashCode());
        assertNotEquals(markDTO1.hashCode(), markDTO3.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        MarkDTO markDTO = new MarkDTO(id, 85, subjectDTO, studentDTO);

        String expected = "MarkDTO{" +
                ", value=85, subjectDto=SubjectDTO{, name='Math', studentDTOList=null, markDTOList=null}, studentDTO=StudentDTO{, surname='John', markDtoList=null, subjectDtoList=null}" +
                '}';

        assertEquals(expected, markDTO.toString());
    }
}