package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.MarkRepository;
import org.example.repository.interfaces.StudentRepository;
import org.example.repository.interfaces.SubjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

// НЕ РЕАЛИЗОВАН
public class MarkRepositoryImpl implements MarkRepository<MarkEntity, UUID> {
    private final ConnectionManager connectionManager;
    private static final String insertMark = "INSERT INTO mark (id,value , student_id, subject_id) VALUES (?, ?, ?, ?);";
    private static final String DELETE_ALL_SQL = "DELETE FROM mark";
    public MarkRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean save(MarkEntity markEntity) throws SQLException {

        try {
            StudentEntity studentEntity = markEntity.getStudentEntity();
            StudentRepository<StudentEntity, UUID> studentRepository = new StudentRepositoryImpl(connectionManager);
            UUID idStudent = studentRepository.getStudentIDBySurname(studentEntity);
            if (idStudent == null) {
                studentRepository.addNewStudent(markEntity.getStudentEntity());
            } else {
                studentEntity.setId(idStudent);
            }
            SubjectEntity subjectEntity = markEntity.getSubjectEntity();
            SubjectRepository<SubjectEntity, UUID> subjectRepository = new SubjectRepositoryImpl(connectionManager);
            UUID idSubject = subjectRepository.getSubjectIdByName(subjectEntity);
            if (idSubject == null) {
                subjectRepository.addNewSubject(markEntity.getSubjectEntity());
            } else {
                subjectEntity.setId(idSubject);
            }
            Connection connection = connectionManager.getConnection();
            // insertMark

            PreparedStatement preparedStatementInsertMark = connection.prepareStatement(insertMark);
            preparedStatementInsertMark.setString(1, markEntity.getId().toString());
            preparedStatementInsertMark.setInt(2, markEntity.getValue());
            preparedStatementInsertMark.setString(3, studentEntity.getId().toString());
            preparedStatementInsertMark.setString(4, subjectEntity.getId().toString());
            preparedStatementInsertMark.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
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