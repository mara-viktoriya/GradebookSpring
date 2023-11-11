package org.example.service.impl;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.controller.mapper.ListMarkMapper;
import org.example.controller.mapper.StudentMapper;
import org.example.controller.mapper.SubjectMapper;
import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.MarkRepository;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private MarkRepository markRepository;
    @Mock
    private SubjectRepository subjectRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ListMarkMapper markMapper;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private SubjectMapper subjectMapper;
    MarkDTO markDTO;
    SubjectDTO subjectDTO;
    StudentDTO studentDTO;
    MarkEntity markEntity;
    SubjectEntity subjectEntity;
    StudentEntity studentEntity;

    @InjectMocks
    StudentServiceImpl studentService;


    @BeforeEach
    void setUp() {
        subjectDTO = new SubjectDTO(UUID.randomUUID(), "Fiz", new ArrayList<>());
        studentDTO = new StudentDTO(UUID.randomUUID(), "Ivanov");
        markDTO = new MarkDTO(UUID.randomUUID(), 5, subjectDTO, studentDTO);

        subjectEntity = new SubjectEntity(subjectDTO.getId(), subjectDTO.getName(), new ArrayList<>());
        studentEntity = new StudentEntity(studentDTO.getId(), studentDTO.getSurname());
        markEntity = new MarkEntity(markDTO.getId(), markDTO.getValue(), studentEntity, subjectEntity);
    }

    @Test
    public void test_saveNewStudent_studentDoesNotExistInRepository_shouldReturnSavedStudentDTO() {

        when(studentMapper.toStudentEntity(studentDTO)).thenReturn(studentEntity);
        when(studentRepository.existsById(studentEntity.getId())).thenReturn(false);
        when(studentRepository.save(studentEntity)).thenReturn(studentEntity);
        when(studentMapper.toStudentDTO(studentEntity)).thenReturn(studentDTO);

        StudentDTO result = studentService.saveNewStudent(studentDTO);

        assertEquals(studentDTO, result);
        verify(studentMapper).toStudentEntity(studentDTO);
        verify(studentRepository).existsById(studentEntity.getId());
        verify(studentRepository).save(studentEntity);
        verify(studentMapper).toStudentDTO(studentEntity);
    }

    @Test
    public void test_deleteStudent_existingStudent_shouldDeleteStudentAndReturnDeletedStudentDTO() {
        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "John Doe");
        StudentEntity studentEntity = new StudentEntity(studentDTO.getId(), studentDTO.getSurname());
        when(studentMapper.toStudentEntity(studentDTO)).thenReturn(studentEntity);
        when(studentRepository.existsById(studentEntity.getId())).thenReturn(true);

        StudentDTO result = studentService.deleteStudent(studentDTO);

        assertEquals(studentDTO, result);
        verify(studentMapper).toStudentEntity(studentDTO);
        verify(studentRepository).existsById(studentEntity.getId());
        verify(studentRepository).delete(studentEntity);
    }

    @Test
    public void test_getMarksBySubject_existingStudentAndSubject_shouldReturnListOfMarkDTOs() {

        List<MarkEntity> markEntities = new ArrayList<>();
        markEntities.add(markEntity);
        when(studentMapper.toStudentEntity(studentDTO)).thenReturn(studentEntity);
        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(studentRepository.existsById(studentEntity.getId())).thenReturn(true);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(true);
        when(markRepository.getMarkEntitiesByStudent_IdAndSubjectId(studentEntity.getId(), subjectDTO.getId())).thenReturn(markEntities);
        List<MarkDTO> expectedMarks = markMapper.toMarkDTOList(markEntities);

        List<MarkDTO> result = studentService.getMarksBySubject(studentDTO, subjectDTO);

        assertEquals(expectedMarks, result);
        verify(studentMapper).toStudentEntity(studentDTO);
        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(studentRepository).existsById(studentEntity.getId());
        verify(subjectRepository).existsById(subjectEntity.getId());
        verify(markRepository).getMarkEntitiesByStudent_IdAndSubjectId(studentEntity.getId(), subjectDTO.getId());
    }

    @Test
    public void test_saveNewStudent_studentAlreadyExistsInRepository_shouldRaiseRuntimeException() {

        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "John Doe");
        StudentEntity studentEntity = new StudentEntity(studentDTO.getId(), studentDTO.getSurname());
        when(studentMapper.toStudentEntity(studentDTO)).thenReturn(studentEntity);
        when(studentRepository.existsById(studentEntity.getId())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> studentService.saveNewStudent(studentDTO));
        verify(studentMapper).toStudentEntity(studentDTO);
        verify(studentRepository).existsById(studentEntity.getId());
    }

}