package org.example.controller.mark;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.MarkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MarkControllerTest {

    @Mock
    private MarkService markService;

    @InjectMocks
    private MarkController markController;
    MarkDTO markDTO;

    @BeforeEach
    void setUp (){
        SubjectDTO subjectDTO = new SubjectDTO(UUID.randomUUID(),"Fiz", new ArrayList<>());
        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "Ivanov");
        markDTO = new MarkDTO(UUID.randomUUID(),5,subjectDTO,studentDTO);
    }
    @Test
    void testDoPost_Success() throws SQLException {
        when(markService.save(any(MarkDTO.class))).thenReturn(markDTO);

        ResponseEntity<MarkDTO> responseEntity = markController.doPost(markDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(markDTO, responseEntity.getBody());
        verify(markService, times(1)).save(any(MarkDTO.class));
    }

    @Test
    void testDoPost_SQLException() throws SQLException {
        when(markService.save(any(MarkDTO.class))).thenThrow(new SQLException());

        ResponseEntity<MarkDTO> responseEntity = markController.doPost(markDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verify(markService, times(1)).save(any(MarkDTO.class));
    }

    @Test
    void testDoPost_ValidationException() {

        markDTO.setId(null);

        ResponseEntity<MarkDTO> responseEntity = markController.doPost(markDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verifyNoInteractions(markService);
    }
}
