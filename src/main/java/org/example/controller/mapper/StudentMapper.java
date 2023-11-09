package org.example.controller.mapper;

import org.example.controller.dto.SubjectDTO;
import org.example.model.entity.StudentEntity;
import org.example.controller.dto.StudentDTO;
import org.example.model.entity.SubjectEntity;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(StudentEntity studentEntity);
    StudentEntity toStudentEntity(StudentDTO studentDTO);

    List<StudentDTO> toStudentDTOList(List<StudentEntity> entities);
    List<StudentEntity> toStudentEntityList(List<StudentDTO> dtos);

}
