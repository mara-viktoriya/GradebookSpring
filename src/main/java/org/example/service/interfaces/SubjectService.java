package org.example.service.interfaces;

import org.example.controller.dto.SubjectDTO;

import java.sql.SQLException;

public interface SubjectService {

    SubjectDTO saveNewSubject (SubjectDTO subjectDTO);

    SubjectDTO deleteSubject(SubjectDTO subjectDTO);

    Object getRepository();

}
