package org.example.servlet.mapper;

import org.example.model.entity.SubjectEntity;
import org.example.servlet.dto.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectMapperTest {

    private SubjectMapper subjectMapper;

    @BeforeEach
    void setUp() {
        subjectMapper = SubjectMapper.INSTANCE;
    }

    @Test
    void testToSubjectDTO() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName("Math");
        SubjectDTO subjectDTO = subjectMapper.toSubjectDTO(subjectEntity);
        assertEquals(subjectEntity.getName(), subjectDTO.getName());
    }

    @Test
    void testToSubjectEntity() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Science");
        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);
        assertEquals(subjectDTO.getName(), subjectEntity.getName());
    }
}
