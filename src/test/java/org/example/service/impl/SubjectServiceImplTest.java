package org.example.service.impl;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.controller.mapper.MarkMapper;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceImplTest {

    @Mock
    private MarkRepository markRepository;
    @Mock
    private SubjectRepository subjectRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private MarkMapper markMapper;
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
    SubjectServiceImpl subjectService;


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
    public void test_saveNewSubject_success() {
        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(false);
        when(subjectRepository.save(subjectEntity)).thenReturn(subjectEntity);
        when(subjectMapper.toSubjectDTO(subjectEntity)).thenReturn(subjectDTO);

        SubjectDTO result = subjectService.saveNewSubject(subjectDTO);

        assertEquals(subjectDTO, result);
        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verify(subjectRepository).save(subjectEntity);
        verify(subjectMapper).toSubjectDTO(subjectEntity);
    }

    @Test
    public void test_deleteSubject_success() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(true);

        SubjectDTO result = subjectService.deleteSubject(subjectDTO);

        assertEquals(subjectDTO, result);
        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verify(subjectRepository).delete(subjectEntity);
    }

    @Test
    public void test_saveNewSubject_subjectExists() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> subjectService.saveNewSubject(subjectDTO));

        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verifyNoMoreInteractions(subjectRepository);
    }

    @Test
    public void test_deleteSubject_subjectNotExists() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> subjectService.deleteSubject(subjectDTO));

        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verifyNoMoreInteractions(subjectRepository);
    }

    @Test
    public void test_saveNewSubject_duplicateId() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> subjectService.saveNewSubject(subjectDTO));

        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verifyNoMoreInteractions(subjectRepository);
    }

    @Test
    public void test_deleteSubject_nonexistentId() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> subjectService.deleteSubject(subjectDTO));

        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verifyNoMoreInteractions(subjectRepository);
    }

    @Test
    public void test_saveNewSubject_emptyMarkList() {

        when(subjectMapper.toSubjectEntity(subjectDTO)).thenReturn(subjectEntity);
        when(subjectRepository.existsById(subjectEntity.getId())).thenReturn(false);
        when(subjectRepository.save(subjectEntity)).thenReturn(subjectEntity);
        when(subjectMapper.toSubjectDTO(subjectEntity)).thenReturn(subjectDTO);

        SubjectDTO result = subjectService.saveNewSubject(subjectDTO);

        assertEquals(subjectDTO, result);
        verify(subjectMapper).toSubjectEntity(subjectDTO);
        verify(subjectRepository).existsById(subjectEntity.getId());
        verify(subjectRepository).save(subjectEntity);
        verify(subjectMapper).toSubjectDTO(subjectEntity);
    }

}