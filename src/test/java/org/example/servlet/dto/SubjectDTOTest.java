package org.example.servlet.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectDTOTest {

    @Test
    void testEmptyConstructor() {
        SubjectDTO subjectDTO = new SubjectDTO();

        assertNotNull(subjectDTO.getId()); // ID должен быть сгенерирован
        assertNull(subjectDTO.getName());
        assertNull(subjectDTO.getStudentDTOList());
        assertNull(subjectDTO.getMarkDTOList());
    }

    @Test
    void testParameterizedConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<MarkDTO> markDTOList = new ArrayList<>();

        SubjectDTO subjectDTO = new SubjectDTO(id, name, studentDTOList, markDTOList);

        assertEquals(id, subjectDTO.getId());
        assertEquals(name, subjectDTO.getName());
        assertEquals(studentDTOList, subjectDTO.getStudentDTOList());
        assertEquals(markDTOList, subjectDTO.getMarkDTOList());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        List<StudentDTO> studentDTOList1 = new ArrayList<>();
        List<StudentDTO> studentDTOList2 = new ArrayList<>();
        List<MarkDTO> markDTOList = new ArrayList<>();

        SubjectDTO subjectDTO1 = new SubjectDTO(id1, "Math", studentDTOList1, markDTOList);
        SubjectDTO subjectDTO2 = new SubjectDTO(id1, "Math", studentDTOList1, markDTOList);
        SubjectDTO subjectDTO3 = new SubjectDTO(id2, "Physics", studentDTOList2, markDTOList);

        assertTrue(subjectDTO1.equals(subjectDTO2));
        assertTrue(subjectDTO2.equals(subjectDTO1));
        assertFalse(subjectDTO1.equals(subjectDTO3));
        assertFalse(subjectDTO3.equals(subjectDTO1));

        assertEquals(subjectDTO1.hashCode(), subjectDTO2.hashCode());
        assertNotEquals(subjectDTO1.hashCode(), subjectDTO3.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<MarkDTO> markDTOList = new ArrayList<>();

        SubjectDTO subjectDTO = new SubjectDTO(id, "Math", studentDTOList, markDTOList);

        String expected = "SubjectDTO{" +
                ", name='Math'" +
                ", studentDTOList=[]" +
                ", markDTOList=[]" +
                '}';

        assertEquals(expected, subjectDTO.toString());
    }
}
