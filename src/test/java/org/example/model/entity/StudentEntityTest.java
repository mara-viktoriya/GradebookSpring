package org.example.model.entity;


import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class StudentEntityTest {


    @Test
    public void test_create_instance_with_valid_parameters() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        StudentEntity studentEntity = new StudentEntity(id, surname);
        assertNotNull(studentEntity);
    }


    @Test
    public void test_get_id() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        StudentEntity studentEntity = new StudentEntity(id, surname);
        assertEquals(id, studentEntity.getId());
    }


    @Test
    public void test_set_and_get_surname() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        StudentEntity studentEntity = new StudentEntity(id, surname);
        assertEquals(surname, studentEntity.getSurname());
    }


    @Test
    public void test_equals_with_same_surname() {
        UUID id1 = UUID.randomUUID();
        String surname = "Smith";
        StudentEntity studentEntity1 = new StudentEntity(id1, surname);
        UUID id2 = UUID.randomUUID();
        StudentEntity studentEntity2 = new StudentEntity(id2, surname);
        assertEquals(studentEntity1, studentEntity2);
    }


    @Test
    public void test_to_string() {
        UUID id = UUID.randomUUID();
        String surname = "Smith";
        StudentEntity studentEntity = new StudentEntity(id, surname);
        String stringRepresentation = studentEntity.toString();
        assertTrue(stringRepresentation.contains(surname));
    }

    @Test
    public void test_equals_with_different_surnames() {
        UUID id1 = UUID.randomUUID();
        String surname1 = "Smith";
        StudentEntity studentEntity1 = new StudentEntity(id1, surname1);
        UUID id2 = UUID.randomUUID();
        String surname2 = "Johnson";
        StudentEntity studentEntity2 = new StudentEntity(id2, surname2);
        assertNotEquals(studentEntity1, studentEntity2);
    }

    @Test
    public void test_create_instance_with_empty_surname() {
        UUID id = UUID.randomUUID();
        String surname = "";
        StudentEntity studentEntity = new StudentEntity(id, surname);
        assertNotNull(studentEntity);
    }

}