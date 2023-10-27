package org.example.service.interfaces;

import org.example.model.entity.SubjectEntity;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;

import java.sql.SQLException;
import java.util.UUID;

public interface SubjectService<T, K> {

    boolean saveNewSubject (SubjectDTO subjectDTO) throws SQLException;

    boolean deleteSubject(SubjectDTO subjectDTO) throws SQLException;



}
