package org.example.service.interfaces;

import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.List;

public interface StudentService{

    StudentDTO saveNewStudent (StudentDTO studentDTO) throws SQLException, RuntimeException;

    StudentDTO deleteStudent (StudentDTO studentDTO) throws SQLException, RuntimeException;

//    List<Long> getMarksBySubject (StudentDTO studentDTO, SubjectDTO subjectDTO) throws SQLException, RuntimeException;

    Object getRepository();
}
