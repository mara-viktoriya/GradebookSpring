package org.example.model.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MarkEntityTest {

    private MarkEntity markEntity;
    private UUID uuid = UUID.randomUUID();
    private int value = 5;
    private StudentEntity studentEntity = new StudentEntity();
    private SubjectEntity subjectEntity = new SubjectEntity();

    @BeforeEach
    public void setUp() {
        markEntity = new MarkEntity(uuid, value,studentEntity ,subjectEntity );
    }

    @Test
    public void testEquals() {
        MarkEntity otherMark = new MarkEntity(markEntity.getId(), markEntity.getValue(), markEntity.getStudentEntity(), markEntity.getSubjectEntity());
        assertEquals(markEntity, otherMark);

    }

    @Test
    public void testHashCode() {
        UUID id = UUID.randomUUID();
        MarkEntity markEntity1 = new MarkEntity(uuid, 5, new StudentEntity(), new SubjectEntity());
        MarkEntity markEntity3 = new MarkEntity(id, 4, new StudentEntity(), new SubjectEntity());

        assertEquals(markEntity.hashCode(), markEntity1.hashCode());
        assertNotEquals(markEntity.hashCode(), markEntity3.hashCode());
    }

    @Test
    public void testToString() {
        String expectedToString = "MarkEntity{id=" + markEntity.getId() + ", value=" + markEntity.getValue() + ", subjectEntity=" + markEntity.getSubjectEntity()  +
                ", studentEntity=" + markEntity.getStudentEntity()+
                '}';

        assertEquals(expectedToString, markEntity.toString());
    }

    @Test
    public void testGetId() {

        assertEquals(uuid, markEntity.getId());
        assertNotNull(markEntity.getId());
    }

    @Test
    public void testGetValue() {
        assertNotNull(markEntity.getValue());
        assertEquals(value, markEntity.getValue());

    }

    @Test
    public void testGetSubjectEntity() {
        assertEquals(subjectEntity, markEntity.getSubjectEntity());
    }

    @Test
    public void testGetStudentEntity() {
        assertEquals(studentEntity, markEntity.getStudentEntity());
    }

    @Test
    public void testSetId() {
        UUID newId = UUID.randomUUID();
        markEntity.setId(newId);
        assertEquals(newId, markEntity.getId());
    }

    @Test
    public void testSetValue() {
        int newValue = 42;
        markEntity.setValue(newValue);
        assertEquals(newValue, markEntity.getValue());
    }

    @Test
    public void testSetSubjectEntity() {
        SubjectEntity subjectEntity = mock(SubjectEntity.class);
        markEntity.setSubjectEntity(subjectEntity);
        assertEquals(subjectEntity, markEntity.getSubjectEntity());
    }

    @Test
    public void testSetStudentEntity() {
        StudentEntity studentEntity1 = mock(StudentEntity.class);
        markEntity.setStudentEntity(studentEntity1);
        assertEquals(studentEntity1, markEntity.getStudentEntity());
    }
}