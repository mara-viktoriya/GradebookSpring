package org.example.model.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectEntityTest {


    @Test
    public void test_create_instance_with_valid_parameters() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        assertNotNull(subjectEntity);
    }
    @Test
    public void test_get_and_set_id() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        UUID newId = UUID.randomUUID();
        subjectEntity.setId(newId);
        assertEquals(newId, subjectEntity.getId());
    }
    @Test
    public void test_get_and_set_name() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        String newName = "Science";
        subjectEntity.setName(newName);
        assertEquals(newName, subjectEntity.getName());
    }
    @Test
    public void test_get_and_set_markList() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        List<MarkEntity> newMarkList = new ArrayList<>();
        subjectEntity.setMarkList(newMarkList);
        assertEquals(newMarkList, subjectEntity.getMarkList());
    }
    @Test
    public void test_equals_with_same_name_and_markList() {
        UUID id1 = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity1 = new SubjectEntity(id1, name, markList);
        UUID id2 = UUID.randomUUID();
        SubjectEntity subjectEntity2 = new SubjectEntity(id2, name, markList);
        assertEquals(subjectEntity1, subjectEntity2);
    }
    @Test
    public void test_create_instance_with_empty_name() {
        UUID id = UUID.randomUUID();
        String name = "";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        assertNotNull(subjectEntity);
    }
    @Test
    public void test_get_and_set_id_with_null() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        subjectEntity.setId(null);
        assertNull(subjectEntity.getId());
    }
    @Test
    public void test_get_and_set_name_with_null() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        subjectEntity.setName(null);
        assertNull(subjectEntity.getName());
    }
    @Test
    public void test_get_and_set_markList_with_null() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkEntity> markList = new ArrayList<>();
        SubjectEntity subjectEntity = new SubjectEntity(id, name, markList);
        subjectEntity.setMarkList(null);
        assertNull(subjectEntity.getMarkList());
    }

}