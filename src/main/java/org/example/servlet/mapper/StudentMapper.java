package org.example.servlet.mapper;

import org.example.model.entity.StudentEntity;
import org.example.servlet.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentDTO toStudentDTO (StudentEntity studentEntity);
    StudentEntity toStudent (StudentDTO studentDTO);
}
