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

public class MarkToStudentMapperTest {

    private MarkToStudentMapper markToStudentMapper;

    @BeforeEach
    void setUp() {
        markToStudentMapper = Mappers.getMapper(MarkToStudentMapper.class);
    }

    @Test
    void testToMarkDTO() {
        MarkEntity markEntity = new MarkEntity();
        markEntity.setId(UUID.randomUUID());
        markEntity.setValue(95);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID());
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(UUID.randomUUID());

        markEntity.setStudentEntity(studentEntity);
        markEntity.setSubjectEntity(subjectEntity);

        MarkDTO markDTO = markToStudentMapper.toMarkDTO(markEntity);

        assertEquals(markEntity.getId(), markDTO.getId());
        assertEquals(markEntity.getValue(), markDTO.getValue());

        assertEquals(markEntity.getStudentEntity().getId(), markDTO.getStudentDTO().getId());
        assertEquals(markEntity.getSubjectEntity().getId(), markDTO.getSubjectDto().getId());
    }

    @Test
    void testToMarkEntity() {
        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(UUID.randomUUID());
        markDTO.setValue(75);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(UUID.randomUUID());
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(UUID.randomUUID());

        markDTO.setStudentDTO(studentDTO);
        markDTO.setSubjectDto(subjectDTO);

        MarkEntity markEntity = markToStudentMapper.toMarkEntity(markDTO);

        assertEquals(markDTO.getId(), markEntity.getId());
        assertEquals(markDTO.getValue(), markEntity.getValue());

        assertEquals(markDTO.getStudentDTO().getId(), markEntity.getStudentEntity().getId());
        assertEquals(markDTO.getSubjectDto().getId(), markEntity.getSubjectEntity().getId());
    }
}
