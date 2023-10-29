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
import java.util.UUID;

@Testcontainers
class MarkRepositoryImplTest {

    MarkRepositoryImpl repository;

    MarkEntity markEntity;

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.12")
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
        repository = new MarkRepositoryImpl(testConnectionManager);
        markEntity = new MarkEntity(UUID.randomUUID(), 5, new StudentEntity(), new SubjectEntity());
    }

    @AfterEach
    void tearDown() throws SQLException {
        repository.clearAll();
    }

    @Test
    void testSave() throws SQLException {
        Assertions.assertTrue(repository.save(markEntity));
    }

    @Test
    void shouldReturnFalse_IfMethodThrows() throws SQLException {
        Assertions.assertFalse(repository.save(new MarkEntity()));
    }
}