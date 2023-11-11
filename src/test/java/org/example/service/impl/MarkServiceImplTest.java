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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MarkServiceImplTest {

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
    MarkServiceImpl markServiceImpl;


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
    public void test_save_MarkDTO_successfully() {
        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(true);
        when(studentRepository.existsById(markEntity.getStudent().getId())).thenReturn(true);

        MarkDTO result = markServiceImpl.save(markDTO);

        assertEquals(markDTO, result);
    }

    @Test
    public void test_throw_exception_if_subject_does_not_exist() {

        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> markServiceImpl.save(markDTO));
    }

    @Test
    public void test_throw_exception_if_student_does_not_exist() {

        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(true);
        when(studentRepository.existsById(markEntity.getStudent().getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> markServiceImpl.save(markDTO));
    }

    @Test
    public void test_save_markDTO_with_null_subject() {
        markDTO.setSubject(null);

        assertThrows(NullPointerException.class, () -> markServiceImpl.save(markDTO));
    }

}