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

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectMapperTest {

    private SubjectMapper subjectMapper;

    @BeforeEach
    void setUp() {
        subjectMapper = Mappers.getMapper(SubjectMapper.class);
    }

    @Test
    void testToSubjectDTO() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(UUID.randomUUID());
        subjectEntity.setName("Math");

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID());
        MarkEntity markEntity = new MarkEntity();
        markEntity.setId(UUID.randomUUID());
        markEntity.setValue(5);
        markEntity.setStudentEntity(studentEntity);
        subjectEntity.setMarkEntitiesList(Collections.singletonList(markEntity));

        StudentEntity studentEntity2 = new StudentEntity();
        studentEntity2.setId(UUID.randomUUID());
        subjectEntity.setStudentEntitiesList(Collections.singletonList(studentEntity2));

        SubjectDTO subjectDTO = subjectMapper.toSubjectDTO(subjectEntity);

        assertEquals(subjectEntity.getId(), subjectDTO.getId());
        assertEquals(subjectEntity.getName(), subjectDTO.getName());

        assertEquals(subjectEntity.getMarkEntitiesList().get(0).getId(), subjectDTO.getMarkDTOList().get(0).getId());
        assertEquals(subjectEntity.getMarkEntitiesList().get(0).getValue(), subjectDTO.getMarkDTOList().get(0).getValue());
        assertEquals(subjectEntity.getMarkEntitiesList().get(0).getStudentEntity().getId(), subjectDTO.getMarkDTOList().get(0).getStudentDTO().getId());

        assertEquals(subjectEntity.getStudentEntitiesList().get(0).getId(), subjectDTO.getStudentDTOList().get(0).getId());
    }

    @Test
    void testToSubjectEntity() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(UUID.randomUUID());
        subjectDTO.setName("Science");

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(UUID.randomUUID());
        MarkDTO markDTO = new MarkDTO();
        markDTO.setId(UUID.randomUUID());
        markDTO.setValue(5);
        markDTO.setStudentDTO(studentDTO);
        subjectDTO.setMarkDTOList(Collections.singletonList(markDTO));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(UUID.randomUUID());
        subjectDTO.setStudentDTOList(Collections.singletonList(studentDTO2));

        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);

        assertEquals(subjectDTO.getId(), subjectEntity.getId());
        assertEquals(subjectDTO.getName(), subjectEntity.getName());

        assertEquals(subjectDTO.getMarkDTOList().get(0).getId(), subjectEntity.getMarkEntitiesList().get(0).getId());
        assertEquals(subjectDTO.getMarkDTOList().get(0).getValue(), subjectEntity.getMarkEntitiesList().get(0).getValue());
        assertEquals(subjectDTO.getMarkDTOList().get(0).getStudentDTO().getId(), subjectEntity.getMarkEntitiesList().get(0).getStudentEntity().getId());

        assertEquals(subjectDTO.getStudentDTOList().get(0).getId(), subjectEntity.getStudentEntitiesList().get(0).getId());
    }
}
