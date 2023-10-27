package org.example.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectEntityTest {

    private SubjectEntity subjectEntity;
    private UUID uuid = UUID.randomUUID();
    private String name = "Math";
    private List<StudentEntity> studentEntitiesList =new ArrayList<>();
    private List<MarkEntity> markEntitiesList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        subjectEntity = new SubjectEntity(uuid, name, studentEntitiesList, markEntitiesList);
    }
    @Test
    void getId() {
        UUID id = subjectEntity.getId();
        assertNotNull(id);
    }

    @Test
    void setId() {
        UUID newId = UUID.randomUUID();
        subjectEntity.setId(newId);
        assertEquals(newId, subjectEntity.getId());
    }

    @Test
    void getName() {
        assertEquals("Math", subjectEntity.getName());
    }

    @Test
    void setName() {
        subjectEntity.setName("Science");
        assertEquals("Science", subjectEntity.getName());
    }

    @Test
    void getStudentEntitiesList() {
        assertNotNull(subjectEntity.getStudentEntitiesList());
    }

    @Test
    void setStudentEntitiesList() {
        List<StudentEntity> students = new ArrayList<>();
        students.add(new StudentEntity(UUID.randomUUID(), "John", new ArrayList<>(), new ArrayList<>()));
        subjectEntity.setStudentEntitiesList(students);
        assertEquals(students, subjectEntity.getStudentEntitiesList());
    }

    @Test
    void getMarkEntitiesList() {
        assertNotNull(subjectEntity.getMarkEntitiesList());
    }

    @Test
    void setMarkEntitiesList() {
        List<MarkEntity> marks = new ArrayList<>();
        marks.add(new MarkEntity());
        subjectEntity.setMarkEntitiesList(marks);
        assertEquals(marks, subjectEntity.getMarkEntitiesList());
    }

    @Test
    void testToString() {
        assertNotNull(subjectEntity.toString());
    }

    @Test
    void testEquals() {
        SubjectEntity sameSubject = new SubjectEntity(
                subjectEntity.getId(),
                subjectEntity.getName(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        assertTrue(subjectEntity.equals(sameSubject));
    }

    @Test
    void testNotEquals() {
        SubjectEntity differentSubject = new SubjectEntity(UUID.randomUUID(), "History", new ArrayList<>(), new ArrayList<>());
        assertFalse(subjectEntity.equals(differentSubject));
    }

    @Test
    void testHashCode() {
        SubjectEntity subject1 = new SubjectEntity(UUID.randomUUID(), "Math", new ArrayList<>(), new ArrayList<>());
        SubjectEntity subject2 = new SubjectEntity(subject1.getId(), subject1.getName(), new ArrayList<>(), new ArrayList<>());

        assertEquals(subject1.hashCode(), subject2.hashCode());
    }
}