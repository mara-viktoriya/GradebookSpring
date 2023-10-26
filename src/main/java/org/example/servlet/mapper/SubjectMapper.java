package org.example.servlet.mapper;

import org.example.model.entity.SubjectEntity;
import org.example.servlet.dto.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SubjectMapper {
    SubjectDTO toSubjectDTO (SubjectDTO subjectDTO);
    SubjectEntity toSubject(SubjectDTO subjectDTO);
}
