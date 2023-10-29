package org.example.model.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class StudentEntityTest {

    private StudentEntity student;
    private UUID uuid = UUID.randomUUID();
    private String surname = "Ivanov";
    private List<MarkEntity> markEntityList = new ArrayList<>();
    private List<SubjectEntity> subjectEntityList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        student = new StudentEntity(uuid, surname, markEntityList, subjectEntityList);
    }
    @Test
    void testGetId() {
        UUID id = student.getId();
        assertEquals(uuid, id);
        assertNotNull(id);
    }
    @Test
    void testSetId() {
        UUID newId = UUID.randomUUID();
        student.setId(newId);
        assertEquals(newId, student.getId());
    }

    @Test
    void testGetSurname() {
        assertEquals(surname, student.getSurname());
        assertNotNull(student.getSurname());
    }

    @Test
    void testSetSurname() {
        String surname = "Smith";
        student.setSurname(surname);
        assertEquals(surname, student.getSurname());
    }

    @Test
    void testGetMarkEntityList() {
        assertNotNull(student.getMarkEntityList());
    }

    @Test
    void testSetMarkEntityList() {
        List<MarkEntity> markEntityList = new ArrayList<>();
        student.setMarkEntityList(markEntityList);
        assertEquals(markEntityList, student.getMarkEntityList());
    }

    @Test
    void testGetSubjectEntityList() {
        assertNotNull(student.getSubjectEntityList());
    }

    @Test
    void testSetSubjectEntityList() {
        List<SubjectEntity> subjectEntityList = new ArrayList<>();
        student.setSubjectEntityList(subjectEntityList);
        assertEquals(subjectEntityList, student.getSubjectEntityList());
    }

    @Test
    void testEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        StudentEntity student1 = new StudentEntity(id1, "Smith", new ArrayList<>(), new ArrayList<>());
        StudentEntity student2 = new StudentEntity(id1, "Smith", new ArrayList<>(), new ArrayList<>());
        StudentEntity student3 = new StudentEntity(id2, "Johnson", new ArrayList<>(), new ArrayList<>());
        assertEquals(student1, student2);
        assertNotEquals(student1, student3);
    }

    @Test
    void testHashCode() {
        UUID id = UUID.randomUUID();
        StudentEntity student1 = new StudentEntity(id, "Smith", new ArrayList<>(), new ArrayList<>());
        StudentEntity student2 = new StudentEntity(id, "Smith", new ArrayList<>(), new ArrayList<>());

        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        StudentEntity student = new StudentEntity(id, "Smith", new ArrayList<>(), new ArrayList<>());

        String expected = "StudentEntity{id=" + id + ", surname='Smith', markEntityList=[], subjectEntityList=[]}";
        assertEquals(expected, student.toString());
    }
}