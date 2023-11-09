package org.example.controller.mapper;

import org.example.model.entity.SubjectEntity;
import org.example.controller.dto.SubjectDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MarkMapper.class})
public interface SubjectMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "markList", target = "markList", qualifiedByName = "toMarkDTOList")
    })
    SubjectDTO toSubjectDTO(SubjectEntity SubjectEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "markList", target = "markList", qualifiedByName = "toMarkEntityList")
    })
    SubjectEntity toSubjectEntity(SubjectDTO subjectDTO);

    List<SubjectDTO> toSubjectDTOList(List<SubjectEntity> entities);
    List<SubjectEntity> toSubjectEntityList(List<SubjectDTO> dtos);



}
