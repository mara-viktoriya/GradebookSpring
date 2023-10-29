package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Testcontainers
class StudentRepositoryImplTest {

    StudentRepositoryImpl repository;
    StudentEntity studentEntity;

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.1")
            .withDatabaseName("test-db")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("db.sql");

    @BeforeEach
    void setUp() {
        ConnectionManager testConnectionManager = new ConnectionManager() {
            @Override
            public Connection getConnection() throws SQLException {
                return postgreSQLContainer.createConnection("");
            }
        };
        repository = new StudentRepositoryImpl(testConnectionManager);
        studentEntity = new StudentEntity(UUID.randomUUID(), "Ivanov", new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    void tearDown() throws SQLException {
        repository.clearAll();
    }


    @Test
    void addNewStudent() throws SQLException {
        Assertions.assertTrue(repository.addNewStudent(studentEntity));
    }

    @Test
    void getStudentIDBySurname() throws SQLException {
        UUID uuid = studentEntity.getId();
        repository.addNewStudent(studentEntity);
        Assertions.assertEquals(uuid, repository.getStudentIDBySurname(studentEntity));
    }

    @Test
    void shouldReturnNull_ifSurnameNotFound() throws SQLException {
        Assertions.assertNull(repository.getStudentIDBySurname(studentEntity));
    }

    @Test
    void isStudentExists() throws SQLException {
        repository.addNewStudent(studentEntity);
        Assertions.assertTrue(repository.isStudentExists(studentEntity));

    }

    @Test
    void deleteStudent() throws SQLException {
        repository.addNewStudent(studentEntity);
        Assertions.assertTrue(repository.deleteStudent(studentEntity));
    }

    @Test
    void getMarksBySubject() throws SQLException {
        SubjectEntity subjectEntityNew = new SubjectEntity();
        subjectEntityNew.setName("Math");
        StudentEntity studentEntityNew = new StudentEntity(studentEntity.getId(), "Ivanov", new ArrayList<>(), new ArrayList<>());
        MarkEntity markEntity1 = new MarkEntity();
        markEntity1.setValue(1);
        markEntity1.setSubjectEntity(subjectEntityNew);
        markEntity1.setStudentEntity(studentEntityNew);
        MarkEntity markEntity2 = new MarkEntity();
        markEntity2.setValue(2);
        markEntity2.setSubjectEntity(subjectEntityNew);
        markEntity2.setStudentEntity(studentEntityNew);
        MarkRepositoryImpl markRepository = new MarkRepositoryImpl(repository.getConnectionManager());
        markRepository.save(markEntity1);
        markRepository.save(markEntity2);
        MarkEntity markEntityNew1 = new MarkEntity();
        markEntityNew1.setValue(1);
        MarkEntity markEntityNew2 = new MarkEntity();
        markEntityNew2.setValue(2);
        List<MarkEntity> markEntityList = new ArrayList<>();
        markEntityList.add(markEntityNew1);
        markEntityList.add(markEntityNew2);
        studentEntityNew.setMarkEntityList(markEntityList);
        StudentEntity marksBySubject = repository.getMarksBySubject(studentEntity, subjectEntityNew);
        Assertions.assertEquals(studentEntityNew, marksBySubject);
    }

    @Test
    void changeStudent() throws SQLException {
        StudentEntity studentEntityNew = new StudentEntity(studentEntity.getId(), "Nikolay", new ArrayList<>(), new ArrayList<>());
        repository.addNewStudent(studentEntity);
        Assertions.assertTrue(repository.changeStudent(studentEntity, studentEntityNew));
    }

    @Test
    void getConnectionManager() {
    }

    @Test
    void clearAll() {
    }
}