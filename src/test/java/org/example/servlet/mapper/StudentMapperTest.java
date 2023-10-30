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

public class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = Mappers.getMapper(StudentMapper.class);
    }

    @Test
    void testToStudentDTO() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID());
        studentEntity.setSurname("John");

        MarkEntity markEntity = new MarkEntity();
        markEntity.setValue(90);
        markEntity.setId(UUID.randomUUID());
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(UUID.randomUUID());
        markEntity.setSubjectEntity(subjectEntity);

        studentEntity.setMarkEntityList(Collections.singletonList(markEntity));

        SubjectEntity subjectEntity2 = new SubjectEntity();
        subjectEntity2.setId(UUID.randomUUID());
        studentEntity.setSubjectEntityList(Collections.singletonList(subjectEntity2));

        StudentDTO studentDTO = studentMapper.toStudentDTO(studentEntity);

        assertEquals(studentEntity.getId(), studentDTO.getId());
        assertEquals(studentEntity.getSurname(), studentDTO.getSurname());

        assertEquals(studentEntity.getMarkEntityList().get(0).getId(), studentDTO.getMarkDtoList().get(0).getId());
        assertEquals(studentEntity.getMarkEntityList().get(0).getValue(), studentDTO.getMarkDtoList().get(0).getValue());
        assertEquals(studentEntity.getMarkEntityList().get(0).getSubjectEntity().getId(), studentDTO.getMarkDtoList().get(0).getSubjectDto().getId());

        assertEquals(studentEntity.getSubjectEntityList().get(0).getId(), studentDTO.getSubjectDtoList().get(0).getId());
    }

    @Test
    void testToStudentEntity() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(UUID.randomUUID());
        studentDTO.setSurname("Jane");

        MarkDTO markDTO = new MarkDTO();
        markDTO.setValue(85);
        markDTO.setId(UUID.randomUUID());
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(UUID.randomUUID());
        markDTO.setSubjectDto(subjectDTO);

        studentDTO.setMarkDtoList(Collections.singletonList(markDTO));

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setId(UUID.randomUUID());
        studentDTO.setSubjectDtoList(Collections.singletonList(subjectDTO2));

        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);

        assertEquals(studentDTO.getId(), studentEntity.getId());
        assertEquals(studentDTO.getSurname(), studentEntity.getSurname());

        assertEquals(studentDTO.getMarkDtoList().get(0).getId(), studentEntity.getMarkEntityList().get(0).getId());
        assertEquals(studentDTO.getMarkDtoList().get(0).getValue(), studentEntity.getMarkEntityList().get(0).getValue());
        assertEquals(studentDTO.getMarkDtoList().get(0).getSubjectDto().getId(), studentEntity.getMarkEntityList().get(0).getSubjectEntity().getId());

        assertEquals(studentDTO.getSubjectDtoList().get(0).getId(), studentEntity.getSubjectEntityList().get(0).getId());
    }
}
