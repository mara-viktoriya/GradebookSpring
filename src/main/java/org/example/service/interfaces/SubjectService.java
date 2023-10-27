package org.example.service.interfaces;

import org.example.servlet.dto.SubjectDTO;

import java.sql.SQLException;

public interface SubjectService<T, K> {

    boolean saveNewSubject (SubjectDTO subjectDTO) throws SQLException;

    boolean deleteSubject(SubjectDTO subjectDTO) throws SQLException;



}
