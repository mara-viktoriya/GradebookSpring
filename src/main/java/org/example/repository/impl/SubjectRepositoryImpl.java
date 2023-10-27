package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.SubjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

// НЕ РЕАЛИЗОВАН
public class SubjectRepositoryImpl implements SubjectRepository<SubjectEntity, UUID> {
    private final ConnectionManager connectionManager;

    private static final String NEW_SUBJECT = "INSERT INTO subject (id, name) VALUES (?, ?);";

    private static final String subjectIdCheck = "SELECT * FROM subject WHERE name = ?;";
    private static final String GET_SUBJECT_BY_NAME = "SELECT id FROM subject WHERE name = ?;";

    public SubjectRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addNewSubject(SubjectEntity subjectEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatementNewSubject = connection.prepareStatement(NEW_SUBJECT)) {
            preparedStatementNewSubject.setString(1, subjectEntity.getId().toString());
            preparedStatementNewSubject.setString(2, subjectEntity.getName());
            preparedStatementNewSubject.executeUpdate();
            return true;
        }

    }

    @Override
    public String getSubjectIdByName(SubjectEntity subjectEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatementSubjectIdCheck = connection.prepareStatement(subjectIdCheck)) {

            preparedStatementSubjectIdCheck.setString(1, subjectEntity.getName());
            ResultSet resultSet = preparedStatementSubjectIdCheck.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("id");
            } else return null;
        }
    }

    @Override
    public boolean isSubjectExists(SubjectEntity subjectEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SUBJECT_BY_NAME)) {
            preparedStatement.setString(1, subjectEntity.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
