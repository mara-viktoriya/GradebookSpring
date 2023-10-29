package org.example.repository.impl;

import org.example.db.ConnectionManager;
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
import java.util.UUID;

@Testcontainers
class SubjectRepositoryImplTest {

    SubjectRepositoryImpl repository;
    SubjectEntity subjectEntity;
    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>( "postgres:13.1" )
            .withDatabaseName( "test-db" )
            .withUsername( "test" )
            .withPassword( "test" )
            .withInitScript( "db.sql" );

    @BeforeEach
    void setUp() {
        ConnectionManager testConnectionManager = new ConnectionManager() {
            @Override
            public Connection getConnection() throws SQLException {
                return postgreSQLContainer.createConnection( "" );
            }
        };
        repository = new SubjectRepositoryImpl( testConnectionManager );
        subjectEntity = new SubjectEntity(UUID.randomUUID(), "Math",new ArrayList<>(),new ArrayList<>());
    }
    @AfterEach
    void tearDown() throws SQLException {
        repository.clearAll();
    }

    @Test
    void addNewSubject() throws SQLException{
        Assertions.assertTrue(repository.addNewSubject(subjectEntity));
    }

    @Test
    void deleteSubject() throws SQLException{
        repository.addNewSubject(subjectEntity);
        Assertions.assertTrue(repository.deleteSubject(subjectEntity));
    }

    @Test
    void getSubjectIdByName() throws SQLException{
        repository.addNewSubject(subjectEntity);
        Assertions.assertEquals(subjectEntity.getId(), repository.getSubjectIdByName(subjectEntity));
    }

    @Test
    void isSubjectExists() throws SQLException{
        repository.addNewSubject(subjectEntity);
        Assertions.assertTrue(repository.isSubjectExists(subjectEntity));
    }
}