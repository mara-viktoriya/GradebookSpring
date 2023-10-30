package org.example.servlet.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class StudentDTOTest {

    @Test
    void testEmptyConstructor() {
        StudentDTO studentDTO = new StudentDTO();

        assertNotNull(studentDTO.getId()); // ID должен быть сгенерирован
        assertNull(studentDTO.getSurname());
        assertNull(studentDTO.getMarkDtoList());
        assertNull(studentDTO.getSubjectDtoList());
    }

    @Test
    void testParameterizedConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        String surname = "John";
        List<MarkDTO> markDtoList = new ArrayList<>();
        List<SubjectDTO> subjectDtoList = new ArrayList<>();

        StudentDTO studentDTO = new StudentDTO(id, surname, markDtoList, subjectDtoList);

        assertEquals(id, studentDTO.getId());
        assertEquals(surname, studentDTO.getSurname());
        assertEquals(markDtoList, studentDTO.getMarkDtoList());
        assertEquals(subjectDtoList, studentDTO.getSubjectDtoList());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        List<MarkDTO> markDtoList1 = new ArrayList<>();
        List<MarkDTO> markDtoList2 = new ArrayList<>();
        List<SubjectDTO> subjectDtoList = new ArrayList<>();

        StudentDTO studentDTO1 = new StudentDTO(id1, "John", markDtoList1, subjectDtoList);
        StudentDTO studentDTO2 = new StudentDTO(id1, "John", markDtoList1, subjectDtoList);
        StudentDTO studentDTO3 = new StudentDTO(id2, "Jane", markDtoList2, subjectDtoList);

        assertTrue(studentDTO1.equals(studentDTO2));
        assertTrue(studentDTO2.equals(studentDTO1));
        assertFalse(studentDTO1.equals(studentDTO3));
        assertFalse(studentDTO3.equals(studentDTO1));

        assertEquals(studentDTO1.hashCode(), studentDTO2.hashCode());
        assertNotEquals(studentDTO1.hashCode(), studentDTO3.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
        List<MarkDTO> markDtoList = new ArrayList<>();
        List<SubjectDTO> subjectDtoList = new ArrayList<>();

        StudentDTO studentDTO = new StudentDTO(id, "John", markDtoList, subjectDtoList);

        String expected = "StudentDTO{" +
                ", surname='John'" +
                ", markDtoList=[]" +
                ", subjectDtoList=[]" +
                '}';

        assertEquals(expected, studentDTO.toString());
    }
}