package org.example.controller.mapper;

import org.example.model.entity.MarkEntity;
import org.example.controller.dto.MarkDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface MarkMapper {

    MarkDTO toMarkDTO(MarkEntity markEntity);

    MarkEntity toMarkEntity(MarkDTO markDTO);

    @Named("toMarkDTOList")
    List<MarkDTO> toMarkDTOList(List<MarkEntity> entities);
    @Named("toMarkEntityList")
    List<MarkEntity> toMarkEntityList(List<MarkDTO> dtos);





}
