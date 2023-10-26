package org.example.servlet.mapper;

import org.example.model.entity.MarkEntity;
import org.example.servlet.dto.MarkDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MarkMapper {

    MarkDTO toMarkDTO(MarkEntity markEntity);
    MarkEntity toMark (MarkDTO markDTO);

}
