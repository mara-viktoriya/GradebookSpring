package org.example.model.entity;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class StudentEntityTest {


    @Test
    public void test_create_instance_with_valid_parameters() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity(id, surname, subjectList);
        assertNotNull(studentEntity);
    }


    @Test
    public void test_get_id() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity(id, surname, subjectList);
        assertEquals(id, studentEntity.getId());
    }


    @Test
    public void test_set_and_get_surname() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity(id, surname, subjectList);
        assertEquals(surname, studentEntity.getSurname());
    }


    @Test
    public void test_equals_with_same_surname() {
        UUID id1 = UUID.randomUUID();
        String surname = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity1 = new StudentEntity(id1, surname, subjectList);
        UUID id2 = UUID.randomUUID();
        StudentEntity studentEntity2 = new StudentEntity(id2, surname, subjectList);
        assertEquals(studentEntity1, studentEntity2);
    }


    @Test
    public void test_to_string() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity(id, surname, subjectList);
        String stringRepresentation = studentEntity.toString();
        assertTrue(stringRepresentation.contains(surname));
    }

    @Test
    public void test_equals_with_different_surnames() {
        UUID id1 = UUID.randomUUID();
        String surname1 = "Smith";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity1 = new StudentEntity(id1, surname1, subjectList);
        UUID id2 = UUID.randomUUID();
        String surname2 = "Johnson";
        StudentEntity studentEntity2 = new StudentEntity(id2, surname2, subjectList);
        assertNotEquals(studentEntity1, studentEntity2);
    }

    @Test
    public void test_create_instance_with_empty_surname() {
        UUID id = UUID.randomUUID();
        String surname = "";
        List<SubjectEntity> subjectList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity(id, surname, subjectList);
        assertNotNull(studentEntity);
    }

}