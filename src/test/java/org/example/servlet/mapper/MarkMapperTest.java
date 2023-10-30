package org.example.servlet.mapper;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.servlet.dto.MarkDTO;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkMapperTest {

    private MarkMapper markMapper;

    @BeforeEach
    void setUp() {
        markMapper = Mappers.getMapper(MarkMapper.class);
    }

    @Test
    void testToMarkDTO() {
        MarkEntity markEntity = new MarkEntity();
        markEntity.setValue(90);
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID());
        markEntity.setStudentEntity(studentEntity);
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(UUID.randomUUID());
        markEntity.setSubjectEntity(subjectEntity);

        MarkDTO markDTO = markMapper.toMarkDTO(markEntity);

        assertEquals(markEntity.getValue(), markDTO.getValue());
        assertEquals(studentEntity.getId(), markDTO.getStudentDTO().getId());
        assertEquals(subjectEntity.getId(), markDTO.getSubjectDto().getId());
    }

    @Test
    void testToMarkEntity() {
        MarkDTO markDTO = new MarkDTO();
        markDTO.setValue(80);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(UUID.randomUUID());
        markDTO.setStudentDTO(studentDTO);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(UUID.randomUUID());
        markDTO.setSubjectDto(subjectDTO);

        MarkEntity markEntity = markMapper.toMarkEntity(markDTO);

        assertEquals(markDTO.getValue(), markEntity.getValue());
        assertEquals(studentDTO.getId(), markEntity.getStudentEntity().getId());
        assertEquals(subjectDTO.getId(), markEntity.getSubjectEntity().getId());
    }
}