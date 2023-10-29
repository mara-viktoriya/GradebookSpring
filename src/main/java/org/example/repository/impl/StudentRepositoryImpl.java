package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// НЕ РЕАЛИЗОВАН
public class StudentRepositoryImpl implements StudentRepository<StudentEntity, UUID> {
    private final ConnectionManager connectionManager;
    private static final String NEW_STUDENT = "INSERT INTO student (id, surname) VALUES (?, ?);";
    private static final String GET_STUDENT_BY_SURNAME = "SELECT id FROM student WHERE surname = ?;";
    private static final String DELETE_STUDENT_BY_SURNAME = "DELETE FROM student WHERE surname = ?;";
    private static final String CHANGE_STUDENT_BY_SURNAME = "UPDATE student SET surname = ? WHERE surname = ?;";
    private static final String GET_MARKS_BY_SUBJECT = "SELECT value FROM mark JOIN subject s ON mark.subject_id = s.id WHERE student_id = (SELECT id FROM student WHERE surname = ?) and subject_id = (SELECT id FROM subject WHERE name = ?)";
    private static final String DELETE_ALL_SQL = "DELETE FROM student";

    public StudentRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addNewStudent(StudentEntity studentEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatementNewStudent = connection.prepareStatement(NEW_STUDENT)) {
            preparedStatementNewStudent.setString(1, studentEntity.getId().toString());
            preparedStatementNewStudent.setString(2, studentEntity.getSurname());
            preparedStatementNewStudent.executeUpdate();
            return true;
        }
    }

    @Override
    public UUID getStudentIDBySurname(StudentEntity studentEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_BY_SURNAME)) {
            preparedStatement.setString(1, studentEntity.getSurname());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return UUID.fromString(resultSet.getString("id"));
            } else return null;

        }
    }

    public boolean isStudentExists(StudentEntity studentEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_BY_SURNAME)) {
            preparedStatement.setString(1, studentEntity.getSurname());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public boolean deleteStudent(StudentEntity studentEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_BY_SURNAME)) {
            preparedStatement.setString(1, studentEntity.getSurname());
            preparedStatement.executeUpdate();
            return true;
        }
    }

    @Override
    public StudentEntity getMarksBySubject(StudentEntity studentEntity, SubjectEntity subjectEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_MARKS_BY_SUBJECT)) {
            preparedStatement.setString(1, studentEntity.getSurname());
            preparedStatement.setString(2, subjectEntity.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MarkEntity> markEntityList = new ArrayList<>();
            while (resultSet.next()) {
                MarkEntity markEntity = new MarkEntity();
                markEntity.setValue(resultSet.getInt("value"));
                markEntityList.add(markEntity);
            }
            studentEntity.setMarkEntityList(markEntityList);
            return studentEntity;
        }

    }

    @Override
    public boolean changeStudent(StudentEntity oldStudentEntity, StudentEntity newStudentEntity) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_STUDENT_BY_SURNAME)) {
            preparedStatement.setString(2, oldStudentEntity.getSurname());
            preparedStatement.setString(1, newStudentEntity.getSurname());
            preparedStatement.executeUpdate();
            return true;
        }
    }
    @Override
    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
    @Override
    public void clearAll() throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement( DELETE_ALL_SQL )){
            statement.executeUpdate();
        }
    }
}
