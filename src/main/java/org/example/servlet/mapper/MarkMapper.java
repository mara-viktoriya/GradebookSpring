package org.example.servlet.mapper;

import org.example.model.entity.MarkEntity;
import org.example.servlet.dto.MarkDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {StudentMapper.class, SubjectMapper.class})
public interface MarkMapper {
    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    @Mapping(source = "subjectEntity", target = "subjectDto")
    @Mapping(source = "studentEntity", target = "studentDTO")

    MarkDTO toMarkDTO(MarkEntity markEntity);

    @InheritInverseConfiguration
    MarkEntity toMarkEntity(MarkDTO markDTO);

}
