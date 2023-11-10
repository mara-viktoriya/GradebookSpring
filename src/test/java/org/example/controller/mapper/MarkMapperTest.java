package org.example.controller.mapper;

import org.example.model.entity.MarkEntity;
import org.example.controller.dto.MarkDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
        // Arrange
        MarkEntity markEntity = TestData.createMarkEntity();

        // Act
        MarkDTO markDTO = mapper.toMarkDTO(markEntity);

        // Assert
        assertNotNull(markDTO);
        assertEquals(markEntity.getId(), markDTO.getId());
        assertEquals(markEntity.getValue(), markDTO.getValue());
        // Assert other properties if needed
    }

    @Test
    void testToMarkEntity() {
        // Arrange
        MarkDTO markDTO = TestData.createMarkDTO();

        // Act
        MarkEntity markEntity = mapper.toMarkEntity(markDTO);

        // Assert
        assertNotNull(markEntity);
        assertEquals(markDTO.getId(), markEntity.getId());
        assertEquals(markDTO.getValue(), markEntity.getValue());
        // Assert other properties if needed
    }

    @Test
    void testToMarkDTOList() {
        // Arrange
        List<MarkEntity> markEntities = TestData.createMarkEntityList();

        // Act
        List<MarkDTO> markDTOs = mapper.toMarkDTOList(markEntities);

        // Assert
        assertNotNull(markDTOs);
        assertEquals(markEntities.size(), markDTOs.size());

        for (int i = 0; i < markEntities.size(); i++) {
            MarkEntity markEntity = markEntities.get(i);
            MarkDTO markDTO = markDTOs.get(i);

            assertEquals(markEntity.getId(), markDTO.getId());
            assertEquals(markEntity.getValue(), markDTO.getValue());
            // Assert other properties if needed
        }
    }

    @Test
    void testToMarkEntityList() {
        // Arrange
        List<MarkDTO> markDTOs = TestData.createMarkDTOList();

        // Act
        List<MarkEntity> markEntities = mapper.toMarkEntityList(markDTOs);

        // Assert
        assertNotNull(markEntities);
        assertEquals(markDTOs.size(), markEntities.size());

        for (int i = 0; i < markDTOs.size(); i++) {
            MarkDTO markDTO = markDTOs.get(i);
            MarkEntity markEntity = markEntities.get(i);

            assertEquals(markDTO.getId(), markEntity.getId());
            assertEquals(markDTO.getValue(), markEntity.getValue());
            // Assert other properties if needed
        }
    }

    private static class TestData {

        static MarkEntity createMarkEntity() {
            MarkEntity markEntity = new MarkEntity();
            markEntity.setId(UUID.randomUUID());
            markEntity.setValue(5);
            // Set other properties if needed
            return markEntity;
        }

        static MarkDTO createMarkDTO() {
            MarkDTO markDTO = new MarkDTO();
            markDTO.setId(UUID.randomUUID());
            markDTO.setValue(5);
            // Set other properties if needed
            return markDTO;
        }

        static List<MarkEntity> createMarkEntityList() {
            MarkEntity markEntity1 = createMarkEntity();
            MarkEntity markEntity2 = createMarkEntity();
            // Add more entities if needed
            return Arrays.asList(markEntity1, markEntity2);
        }

        static List<MarkDTO> createMarkDTOList() {
            MarkDTO markDTO1 = createMarkDTO();
            MarkDTO markDTO2 = createMarkDTO();
            // Add more DTOs if needed
            return Arrays.asList(markDTO1, markDTO2);
        }
    }
}

