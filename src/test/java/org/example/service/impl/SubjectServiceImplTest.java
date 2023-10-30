package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.SubjectRepository;
import org.example.service.interfaces.SubjectService;
import org.example.servlet.dto.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubjectServiceImplTest {
    private SubjectRepository<SubjectEntity, UUID> subjectRepository;
    private SubjectService<SubjectEntity, UUID> subjectService;

    @BeforeEach
    void setUp() {
        subjectRepository = Mockito.mock(SubjectRepository.class);
        subjectService = new SubjectServiceImpl(subjectRepository);
    }

    @Test
    void testSaveNewSubjectSuccess() throws SQLException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        when(subjectRepository.addNewSubject(any(SubjectEntity.class))).thenReturn(true);
        assertTrue(subjectService.saveNewSubject(subjectDTO));
    }

    @Test
    void testSaveNewSubjectFailure() throws SQLException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        when(subjectRepository.addNewSubject(any(SubjectEntity.class))).thenReturn(false);
        assertFalse(subjectService.saveNewSubject(subjectDTO));
    }

    @Test
    void testDeleteSubjectSuccess() throws SQLException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        when(subjectRepository.isSubjectExists(any(SubjectEntity.class))).thenReturn(true);
        when(subjectRepository.deleteSubject(any(SubjectEntity.class))).thenReturn(true);
        assertTrue(subjectService.deleteSubject(subjectDTO));
    }

    @Test
    void testDeleteSubjectFailure() throws SQLException {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        when(subjectRepository.isSubjectExists(any(SubjectEntity.class))).thenReturn(false);
        assertThrows(RuntimeException.class, () -> subjectService.deleteSubject(subjectDTO));
    }
}