package org.example.servlet.mapper;

import org.example.model.entity.MarkEntity;
import org.example.servlet.dto.MarkDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MarkToSubjectMapper {

    MarkToSubjectMapper INSTANCE = Mappers.getMapper(MarkToSubjectMapper.class);

    @Mapping(source = "subjectEntity", target = "subjectDto")
    @Mapping(source = "studentEntity", target = "studentDTO")
    MarkDTO toMarkDTO(MarkEntity markEntity);

    @InheritInverseConfiguration
    MarkEntity toMarkEntity(MarkDTO markDTO);
}
