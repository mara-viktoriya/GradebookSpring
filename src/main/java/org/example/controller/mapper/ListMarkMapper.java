package org.example.controller.mapper;

import org.example.controller.dto.MarkDTO;
import org.example.model.entity.MarkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListMarkMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "value", target = "value"),
            @Mapping(ignore = true, target = "student"),
            @Mapping(ignore = true, target = "subject")
    })
    MarkDTO toMarkDTO(MarkEntity markEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "value", target = "value"),
            @Mapping(ignore = true, target = "student"),
            @Mapping(ignore = true, target = "subject")
    })
    MarkEntity toMarkEntity(MarkDTO markDTO);

    List<MarkDTO> toMarkDTOList(List<MarkEntity> entities);
    List<MarkEntity> toMarkEntityList(List<MarkDTO> dtos);

}
