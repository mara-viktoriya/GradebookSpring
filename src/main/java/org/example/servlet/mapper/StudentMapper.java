package org.example.servlet.mapper;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.servlet.dto.MarkDTO;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {MarkMapper.class, SubjectMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "markEntityList", target = "markDtoList")
    @Mapping(source = "subjectEntityList", target = "subjectDtoList")
    StudentDTO toStudentDTO(StudentEntity studentEntity);

    @InheritInverseConfiguration
    StudentEntity toStudentEntity(StudentDTO studentDTO);
//    List<StudentDTO> toStudentDTOList(List<StudentEntity> list);
//    List<StudentEntity> toStudentEntityList(List<StudentDTO> list);
}
