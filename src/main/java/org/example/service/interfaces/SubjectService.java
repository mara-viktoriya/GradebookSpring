package org.example.service.interfaces;

import org.example.controller.dto.SubjectDTO;

import java.sql.SQLException;

public interface SubjectService {

    SubjectDTO saveNewSubject (SubjectDTO subjectDTO) throws SQLException;

    boolean deleteSubject(SubjectDTO subjectDTO) throws SQLException;

    Object getRepository();

}
