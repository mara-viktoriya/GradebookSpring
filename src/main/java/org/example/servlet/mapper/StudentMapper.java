package org.example.servlet.mapper;

import org.example.model.entity.StudentEntity;
import org.example.servlet.dto.StudentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {MarkToStudentMapper.class, SubjectMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "markEntityList", target = "markDtoList")
    @Mapping(source = "subjectEntityList", target = "subjectDtoList")
    StudentDTO toStudentDTO(StudentEntity studentEntity);

    @InheritInverseConfiguration
    StudentEntity toStudentEntity(StudentDTO studentDTO);

}
