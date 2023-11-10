package org.example.controller.subject;

import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.SubjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubjectControllerTest {

    @Mock
    private SubjectService subjectService;

    @InjectMocks
    private SubjectController subjectController;

    @Test
    void testDoPost_Success() {
        SubjectDTO subjectDTO = new SubjectDTO(UUID.randomUUID(), "SubjectName", new ArrayList<>());
        when(subjectService.saveNewSubject(any(SubjectDTO.class))).thenReturn(subjectDTO);

        ResponseEntity<SubjectDTO> responseEntity = subjectController.doPost(subjectDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(subjectDTO, responseEntity.getBody());
        verify(subjectService, times(1)).saveNewSubject(any(SubjectDTO.class));
    }

    @Test
    void testDoPost_ValidationException() {
        SubjectDTO subjectDTO = new SubjectDTO();

        ResponseEntity<SubjectDTO> responseEntity = subjectController.doPost(subjectDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verifyNoInteractions(subjectService);
    }

    @Test
    void testDoDelete_Success() {
        SubjectDTO subjectDTO = new SubjectDTO(UUID.randomUUID(), "SubjectName", new ArrayList<>());
        when(subjectService.deleteSubject(any(SubjectDTO.class))).thenReturn(subjectDTO);

        ResponseEntity<SubjectDTO> responseEntity = subjectController.doDelete(subjectDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(subjectDTO, responseEntity.getBody());
        verify(subjectService, times(1)).deleteSubject(any(SubjectDTO.class));
    }

    @Test
    void testDoDelete_ValidationException() {
        SubjectDTO subjectDTO = new SubjectDTO();

        ResponseEntity<SubjectDTO> responseEntity = subjectController.doDelete(subjectDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verifyNoInteractions(subjectService);
    }
}
