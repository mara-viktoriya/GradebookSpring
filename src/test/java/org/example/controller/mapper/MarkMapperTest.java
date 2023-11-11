package org.example.controller.mapper;

import org.example.controller.dto.MarkDTO;
import org.example.model.entity.MarkEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarkMapperTest {

    @InjectMocks
    private final MarkMapper mapper = Mappers.getMapper(MarkMapper.class);

    @Mock
    private SubjectMapper subjectMapper;

    @Mock
    private StudentMapper studentMapper;

    public MarkMapperTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToMarkDTO() {
        MarkEntity markEntity = TestData.createMarkEntity();

        MarkDTO markDTO = mapper.toMarkDTO(markEntity);

        assertNotNull(markDTO);
        assertEquals(markEntity.getId(), markDTO.getId());
        assertEquals(markEntity.getValue(), markDTO.getValue());
    }

    @Test
    void testToMarkEntity() {
        MarkDTO markDTO = TestData.createMarkDTO();

        MarkEntity markEntity = mapper.toMarkEntity(markDTO);

        assertNotNull(markEntity);
        assertEquals(markDTO.getId(), markEntity.getId());
        assertEquals(markDTO.getValue(), markEntity.getValue());
    }

    @Test
    void testToMarkDTOList() {
        List<MarkEntity> markEntities = TestData.createMarkEntityList();

        List<MarkDTO> markDTOs = mapper.toMarkDTOList(markEntities);

        assertNotNull(markDTOs);
        assertEquals(markEntities.size(), markDTOs.size());

        for (int i = 0; i < markEntities.size(); i++) {
            MarkEntity markEntity = markEntities.get(i);
            MarkDTO markDTO = markDTOs.get(i);

            assertEquals(markEntity.getId(), markDTO.getId());
            assertEquals(markEntity.getValue(), markDTO.getValue());
        }
    }

    @Test
    void testToMarkEntityList() {
        List<MarkDTO> markDTOs = TestData.createMarkDTOList();

        List<MarkEntity> markEntities = mapper.toMarkEntityList(markDTOs);

        assertNotNull(markEntities);
        assertEquals(markDTOs.size(), markEntities.size());

        for (int i = 0; i < markDTOs.size(); i++) {
            MarkDTO markDTO = markDTOs.get(i);
            MarkEntity markEntity = markEntities.get(i);

            assertEquals(markDTO.getId(), markEntity.getId());
            assertEquals(markDTO.getValue(), markEntity.getValue());
        }
    }

    private static class TestData {

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

        static List<MarkEntity> createMarkEntityList() {
            MarkEntity markEntity1 = createMarkEntity();
            MarkEntity markEntity2 = createMarkEntity();
            return Arrays.asList(markEntity1, markEntity2);
        }

        static List<MarkDTO> createMarkDTOList() {
            MarkDTO markDTO1 = createMarkDTO();
            MarkDTO markDTO2 = createMarkDTO();
            return Arrays.asList(markDTO1, markDTO2);
        }
    }
}

