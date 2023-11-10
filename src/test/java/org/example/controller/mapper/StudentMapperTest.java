package org.example.controller.mapper;

import org.example.controller.dto.StudentDTO;
import org.example.model.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentMapperTest {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Test
    void testToStudentDTO() {
        // Arrange
        StudentEntity studentEntity = TestData.createStudentEntity();

        // Act
        StudentDTO studentDTO = mapper.toStudentDTO(studentEntity);

        // Assert
        assertNotNull(studentDTO);
        assertEquals(studentEntity.getId(), studentDTO.getId());
        assertEquals(studentEntity.getSurname(), studentDTO.getSurname());
        // Assert other properties if needed
    }

    @Test
    void testToStudentEntity() {
        // Arrange
        StudentDTO studentDTO = TestData.createStudentDTO();

        // Act
        StudentEntity studentEntity = mapper.toStudentEntity(studentDTO);

        // Assert
        assertNotNull(studentEntity);
        assertEquals(studentDTO.getId(), studentEntity.getId());
        assertEquals(studentDTO.getSurname(), studentEntity.getSurname());
        // Assert other properties if needed
    }

    @Test
    void testToStudentDTOList() {
        // Arrange
        List<StudentEntity> studentEntities = TestData.createStudentEntityList();

        // Act
        List<StudentDTO> studentDTOs = mapper.toStudentDTOList(studentEntities);

        // Assert
        assertNotNull(studentDTOs);
        assertEquals(studentEntities.size(), studentDTOs.size());

        for (int i = 0; i < studentEntities.size(); i++) {
            StudentEntity studentEntity = studentEntities.get(i);
            StudentDTO studentDTO = studentDTOs.get(i);

            assertEquals(studentEntity.getId(), studentDTO.getId());
            assertEquals(studentEntity.getSurname(), studentDTO.getSurname());
            // Assert other properties if needed
        }
    }

    @Test
    void testToStudentEntityList() {
        // Arrange
        List<StudentDTO> studentDTOs = TestData.createStudentDTOList();

        // Act
        List<StudentEntity> studentEntities = mapper.toStudentEntityList(studentDTOs);

        // Assert
        assertNotNull(studentEntities);
        assertEquals(studentDTOs.size(), studentEntities.size());

        for (int i = 0; i < studentDTOs.size(); i++) {
            StudentDTO studentDTO = studentDTOs.get(i);
            StudentEntity studentEntity = studentEntities.get(i);

            assertEquals(studentDTO.getId(), studentEntity.getId());
            assertEquals(studentDTO.getSurname(), studentEntity.getSurname());
            // Assert other properties if needed
        }
    }

    private static class TestData {

        static StudentEntity createStudentEntity() {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(UUID.randomUUID());
            studentEntity.setSurname("Doe");
            // Set other properties if needed
            return studentEntity;
        }

        static StudentDTO createStudentDTO() {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(UUID.randomUUID());
            studentDTO.setSurname("Doe");
            // Set other properties if needed
            return studentDTO;
        }

        static List<StudentEntity> createStudentEntityList() {
            StudentEntity studentEntity1 = createStudentEntity();
            StudentEntity studentEntity2 = createStudentEntity();
            // Add more entities if needed
            return Arrays.asList(studentEntity1, studentEntity2);
        }

        static List<StudentDTO> createStudentDTOList() {
            StudentDTO studentDTO1 = createStudentDTO();
            StudentDTO studentDTO2 = createStudentDTO();
            // Add more DTOs if needed
            return Arrays.asList(studentDTO1, studentDTO2);
        }
    }
}
