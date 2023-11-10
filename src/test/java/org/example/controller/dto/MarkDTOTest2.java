package org.example.controller.dto;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarkDTOTest2 {


    // Creating a new instance of MarkDTO with valid parameters should return the expected object.
    @Test
    public void test_createInstanceWithValidParameters() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO(id, value, subject, student);

        assertEquals(id, markDTO.getId());
        assertEquals(value, markDTO.getValue());
        assertEquals(subject, markDTO.getSubject());
        assertEquals(student, markDTO.getStudent());
    }

    // Two MarkDTO objects with the same value for 'value', 'subject' and 'student' should be equal.
    @Test
    public void test_equals() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO1 = new MarkDTO(id, value, subject, student);
        MarkDTO markDTO2 = new MarkDTO(id, value, subject, student);

        assertEquals(markDTO1, markDTO2);
    }

    // The 'toString' method should return a string representation of the MarkDTO object.
    @Test
    public void test_toString() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO(id, value, subject, student);

        String expected = "MarkDTO{" +
                "value=" + value +
                ", subjectDto=" + subject +
                ", studentDTO=" + student +
                '}';

        assertEquals(expected, markDTO.toString());
    }

    // Setting and getting the 'id' field of a MarkDTO object should work as expected.
    @Test
    public void test_setAndGetId() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(id);
        markDTO.setValue(value);
        markDTO.setSubject(subject);
        markDTO.setStudent(student);

        assertEquals(id, markDTO.getId());
    }

    // Setting and getting the 'value' field of a MarkDTO object should work as expected.
    @Test
    public void test_setAndGetValue() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(id);
        markDTO.setValue(value);
        markDTO.setSubject(subject);
        markDTO.setStudent(student);

        assertEquals(value, markDTO.getValue());
    }

    // Setting and getting the 'subject' field of a MarkDTO object should work as expected.
    @Test
    public void test_setAndGetSubject() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(id);
        markDTO.setValue(value);
        markDTO.setSubject(subject);
        markDTO.setStudent(student);

        assertEquals(subject, markDTO.getSubject());
    }

    // Creating a new instance of MarkDTO with a null 'id' field should throw a NullPointerException.
    @Test
    public void test_createInstanceWithNullId() {
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        assertThrows(NullPointerException.class, () -> new MarkDTO(null, value, subject, student));
    }

    // Creating a new instance of MarkDTO with a 'value' field less than 1 should throw a ConstraintViolationException.
    @Test
    public void test_createInstanceWithValueLessThanOne() {
        UUID id = UUID.randomUUID();
        int value = 0;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        assertThrows(ConstraintViolationException.class, () -> new MarkDTO(id, value, subject, student));
    }

    // Creating a new instance of MarkDTO with a 'value' field greater than 5 should throw a ConstraintViolationException.
    @Test
    public void test_createInstanceWithValueGreaterThanFive() {
        UUID id = UUID.randomUUID();
        int value = 6;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        assertThrows(ConstraintViolationException.class, () -> new MarkDTO(id, value, subject, student));
    }

    // Creating a new instance of MarkDTO with a null 'subject' field should throw a NullPointerException.
    @Test
    public void test_createInstanceWithNullSubject() {
        UUID id = UUID.randomUUID();
        int value = 3;
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        assertThrows(NullPointerException.class, () -> new MarkDTO(id, value, null, student));
    }

    // Creating a new instance of MarkDTO with a null 'student' field should throw a NullPointerException.
    @Test
    public void test_createInstanceWithNullStudent() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());

        assertThrows(NullPointerException.class, () -> new MarkDTO(id, value, subject, null));
    }

    // Setting and getting the 'student' field of a MarkDTO object should work as expected.
    @Test
    public void test_setAndGetStudent() {
        UUID id = UUID.randomUUID();
        int value = 3;
        SubjectDTO subject = new SubjectDTO(UUID.randomUUID(), "Math", new ArrayList<>());
        StudentDTO student = new StudentDTO(UUID.randomUUID(), "John");

        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(id);
        markDTO.setValue(value);
        markDTO.setSubject(subject);
        markDTO.setStudent(student);

        assertEquals(student, markDTO.getStudent());
    }

}