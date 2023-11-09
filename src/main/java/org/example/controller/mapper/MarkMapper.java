package org.example.controller.mapper;

import org.example.model.entity.MarkEntity;
import org.example.controller.dto.MarkDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface MarkMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "student", target = "student"),
            @Mapping(source = "subject", target = "subject"),
    })
    MarkDTO toMarkDTO(MarkEntity markEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "student", target = "student"),
            @Mapping(source = "subject", target = "subject"),
    })
    MarkEntity toMarkEntity(MarkDTO markDTO);

    @Named("toMarkDTOList")
    List<MarkDTO> toMarkDTOList(List<MarkEntity> entities);
    @Named("toMarkEntityList")
    List<MarkEntity> toMarkEntityList(List<MarkDTO> dtos);





}
