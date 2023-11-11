package org.example.controller.mapper;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.model.entity.MarkEntity;
import org.example.model.entity.SubjectEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SubjectMapperTest {

    private  MarkMapper markMapper = mock(MarkMapper.class);
    private  SubjectMapperImpl subjectMapper = new SubjectMapperImpl();

    @BeforeEach
    void setUp(){
        ReflectionTestUtils.setField(subjectMapper, "markMapper", markMapper);
    }

    @Test
    void testToSubjectDTO() {
        SubjectEntity subjectEntity = TestData.createSubjectEntity();
        when(markMapper.toMarkDTOList(subjectEntity.getMarkList())).thenReturn(Arrays.asList(TestData.createMarkDTO()));
        SubjectDTO subjectDTO = subjectMapper.toSubjectDTO(subjectEntity);

        assertNotNull(subjectDTO);
        assertEquals(subjectEntity.getId(), subjectDTO.getId());
        assertEquals(subjectEntity.getName(), subjectDTO.getName());
    }

    @Test
    void testToSubjectEntity() {
        SubjectDTO subjectDTO = TestData.createSubjectDTO();

        when(markMapper.toMarkEntityList(subjectDTO.getMarkList())).thenReturn(Arrays.asList(TestData.createMarkEntity()));

        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);

        assertNotNull(subjectEntity);
        assertEquals(subjectDTO.getId(), subjectEntity.getId());
        assertEquals(subjectDTO.getName(), subjectEntity.getName());
    }

    @Test
    void testToSubjectDTOList() {
        List<SubjectEntity> subjectEntities = TestData.createSubjectEntityList();

        for (SubjectEntity subjectEntity : subjectEntities) {
            when(markMapper.toMarkDTOList(subjectEntity.getMarkList())).thenReturn(Arrays.asList(TestData.createMarkDTO()));
        }

        List<SubjectDTO> subjectDTOs = subjectMapper.toSubjectDTOList(subjectEntities);

        assertNotNull(subjectDTOs);
        assertEquals(subjectEntities.size(), subjectDTOs.size());

        for (int i = 0; i < subjectEntities.size(); i++) {
            SubjectEntity subjectEntity = subjectEntities.get(i);
            SubjectDTO subjectDTO = subjectDTOs.get(i);

            assertEquals(subjectEntity.getId(), subjectDTO.getId());
            assertEquals(subjectEntity.getName(), subjectDTO.getName());
        }
    }

    @Test
    void testToSubjectEntityList() {
        List<SubjectDTO> subjectDTOs = TestData.createSubjectDTOList();

        for (SubjectDTO subjectDTO : subjectDTOs) {
            when(markMapper.toMarkEntityList(subjectDTO.getMarkList())).thenReturn(Arrays.asList(TestData.createMarkEntity()));
        }

        List<SubjectEntity> subjectEntities = subjectMapper.toSubjectEntityList(subjectDTOs);

        assertNotNull(subjectEntities);
        assertEquals(subjectDTOs.size(), subjectEntities.size());

        for (int i = 0; i < subjectDTOs.size(); i++) {
            SubjectDTO subjectDTO = subjectDTOs.get(i);
            SubjectEntity subjectEntity = subjectEntities.get(i);

            assertEquals(subjectDTO.getId(), subjectEntity.getId());
            assertEquals(subjectDTO.getName(), subjectEntity.getName());
        }
    }

    private static class TestData {

        static SubjectEntity createSubjectEntity() {
            SubjectEntity subjectEntity = new SubjectEntity();
            subjectEntity.setId(UUID.randomUUID());
            subjectEntity.setName("Math");
            subjectEntity.setMarkList(Arrays.asList(createMarkEntity()));
            return subjectEntity;
        }

        static SubjectDTO createSubjectDTO() {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(UUID.randomUUID());
            subjectDTO.setName("Math");
            subjectDTO.setMarkList(Arrays.asList(createMarkDTO()));
            return subjectDTO;
        }

        static List<SubjectEntity> createSubjectEntityList() {
            SubjectEntity subjectEntity1 = createSubjectEntity();
            SubjectEntity subjectEntity2 = createSubjectEntity();
            return Arrays.asList(subjectEntity1, subjectEntity2);
        }

        static List<SubjectDTO> createSubjectDTOList() {
            SubjectDTO subjectDTO1 = createSubjectDTO();
            SubjectDTO subjectDTO2 = createSubjectDTO();
            return Arrays.asList(subjectDTO1, subjectDTO2);
        }

        static MarkEntity createMarkEntity() {
            MarkEntity markEntity = new MarkEntity();
            markEntity.setId(UUID.randomUUID());
            markEntity.setValue(5);
            return markEntity;
        }

        static MarkDTO createMarkDTO() {
            MarkDTO markDTO = new MarkDTO();
            markDTO.setId(UUID.randomUUID());
            markDTO.setValue(5);
            return markDTO;
        }
    }
}



