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
        StudentEntity studentEntity = TestData.createStudentEntity();

        StudentDTO studentDTO = mapper.toStudentDTO(studentEntity);

        assertNotNull(studentDTO);
        assertEquals(studentEntity.getId(), studentDTO.getId());
        assertEquals(studentEntity.getSurname(), studentDTO.getSurname());
    }

    @Test
    void testToStudentEntity() {
        StudentDTO studentDTO = TestData.createStudentDTO();

        StudentEntity studentEntity = mapper.toStudentEntity(studentDTO);

        assertNotNull(studentEntity);
        assertEquals(studentDTO.getId(), studentEntity.getId());
        assertEquals(studentDTO.getSurname(), studentEntity.getSurname());
    }

    @Test
    void testToStudentDTOList() {
        List<StudentEntity> studentEntities = TestData.createStudentEntityList();

        List<StudentDTO> studentDTOs = mapper.toStudentDTOList(studentEntities);

        assertNotNull(studentDTOs);
        assertEquals(studentEntities.size(), studentDTOs.size());

        for (int i = 0; i < studentEntities.size(); i++) {
            StudentEntity studentEntity = studentEntities.get(i);
            StudentDTO studentDTO = studentDTOs.get(i);

            assertEquals(studentEntity.getId(), studentDTO.getId());
            assertEquals(studentEntity.getSurname(), studentDTO.getSurname());
        }
    }

    @Test
    void testToStudentEntityList() {
        List<StudentDTO> studentDTOs = TestData.createStudentDTOList();

        List<StudentEntity> studentEntities = mapper.toStudentEntityList(studentDTOs);

        assertNotNull(studentEntities);
        assertEquals(studentDTOs.size(), studentEntities.size());

        for (int i = 0; i < studentDTOs.size(); i++) {
            StudentDTO studentDTO = studentDTOs.get(i);
            StudentEntity studentEntity = studentEntities.get(i);

            assertEquals(studentDTO.getId(), studentEntity.getId());
            assertEquals(studentDTO.getSurname(), studentEntity.getSurname());
        }
    }

    private static class TestData {

        static StudentEntity createStudentEntity() {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(UUID.randomUUID());
            studentEntity.setSurname("Doe");
            return studentEntity;
        }

        static StudentDTO createStudentDTO() {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(UUID.randomUUID());
            studentDTO.setSurname("Doe");
            return studentDTO;
        }

        static List<StudentEntity> createStudentEntityList() {
            StudentEntity studentEntity1 = createStudentEntity();
            StudentEntity studentEntity2 = createStudentEntity();
            return Arrays.asList(studentEntity1, studentEntity2);
        }

        static List<StudentDTO> createStudentDTOList() {
            StudentDTO studentDTO1 = createStudentDTO();
            StudentDTO studentDTO2 = createStudentDTO();
            return Arrays.asList(studentDTO1, studentDTO2);
        }
    }
}
