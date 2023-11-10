package org.example.model.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MarkEntityTest {

    @Test
    public void test_create_instance_with_valid_parameters() {

        UUID id = UUID.randomUUID();
        int value = 80;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();


        MarkEntity markEntity = new MarkEntity(id, value, student, subject);


        assertNotNull(markEntity);
        assertEquals(id, markEntity.getId());
        assertEquals(value, markEntity.getValue());
        assertEquals(student, markEntity.getStudent());
        assertEquals(subject, markEntity.getSubject());
    }

    @Test
    public void test_equals_with_same_value() {

        UUID id = UUID.randomUUID();
        int value = 80;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();
        MarkEntity markEntity1 = new MarkEntity(id, value, student, subject);
        MarkEntity markEntity2 = new MarkEntity(id, value, student, subject);

        assertEquals(markEntity1, markEntity2);
    }

    @Test
    public void test_set_and_get_value() {

        UUID id = UUID.randomUUID();
        int value = 5;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();
        MarkEntity markEntity = new MarkEntity(id, value, student, subject);


        markEntity.setValue(4);
        int retrievedValue = markEntity.getValue();


        assertEquals(4, retrievedValue);
    }


    @Test
    public void test_set_and_get_subject() {

        UUID id = UUID.randomUUID();
        int value = 5;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();
        MarkEntity markEntity = new MarkEntity(id, value, student, subject);


        SubjectEntity newSubject = new SubjectEntity();
        markEntity.setSubject(newSubject);
        SubjectEntity retrievedSubject = markEntity.getSubject();


        assertEquals(newSubject, retrievedSubject);
    }

    @Test
    public void test_set_and_get_student() {

        UUID id = UUID.randomUUID();
        int value = 5;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();
        MarkEntity markEntity = new MarkEntity(id, value, student, subject);


        StudentEntity newStudent = new StudentEntity();
        markEntity.setStudent(newStudent);
        StudentEntity retrievedStudent = markEntity.getStudent();


        assertEquals(newStudent, retrievedStudent);
    }


    @Test
    public void test_to_string() {

        UUID id = UUID.randomUUID();
        int value = 5;
        StudentEntity student = new StudentEntity();
        SubjectEntity subject = new SubjectEntity();
        MarkEntity markEntity = new MarkEntity(id, value, student, subject);

        String stringRepresentation = markEntity.toString();


        assertTrue(stringRepresentation.contains(id.toString()));
        assertTrue(stringRepresentation.contains(Integer.toString(value)));
    }
}