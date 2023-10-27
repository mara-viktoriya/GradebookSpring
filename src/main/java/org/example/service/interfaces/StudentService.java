package org.example.service.interfaces;

import org.example.model.entity.StudentEntity;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.UUID;

public interface StudentService<T, K>{

    boolean saveNewStudent (StudentDTO studentDTO) throws SQLException, RuntimeException;

    boolean deleteStudent (StudentDTO studentDTO) throws SQLException, RuntimeException;

    StudentDTO getMarksBySubject (StudentDTO studentDTO, SubjectDTO subjectDTO) throws SQLException, RuntimeException;

    boolean changeStudent (StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException, RuntimeException;

}
