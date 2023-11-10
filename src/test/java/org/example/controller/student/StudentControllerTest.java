package org.example.controller.student;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testDoPost_Success() throws SQLException {
        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "Surname");
        when(studentService.saveNewStudent(any(StudentDTO.class))).thenReturn(studentDTO);

        ResponseEntity<StudentDTO> responseEntity = studentController.doPost(studentDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(studentDTO, responseEntity.getBody());
        verify(studentService, times(1)).saveNewStudent(any(StudentDTO.class));
    }

    @Test
    void testDoPost_SQLException() throws SQLException {
        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "Surname");
        when(studentService.saveNewStudent(any(StudentDTO.class))).thenThrow(new SQLException());

        ResponseEntity<StudentDTO> responseEntity = studentController.doPost(studentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verify(studentService, times(1)).saveNewStudent(any(StudentDTO.class));
    }

    @Test
    void testDoPost_ValidationException() {
        StudentDTO studentDTO = new StudentDTO();

        ResponseEntity<StudentDTO> responseEntity = studentController.doPost(studentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        verifyNoInteractions(studentService);
    }

    @Test
    void testDoDelete_Success() throws SQLException {
        StudentDTO studentDTO = new StudentDTO(UUID.randomUUID(), "Surname");
        when(studentService.deleteStudent(any(StudentDTO.class))).thenReturn(studentDTO);

        ResponseEntity<StudentDTO> responseEntity = studentController.doDelete(studentDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(studentDTO, responseEntity.getBody());
        verify(studentService, times(1)).deleteStudent(any(StudentDTO.class));
    }


    @Test
    void testDoGet_Success() throws SQLException {
        UUID idStudent = UUID.randomUUID();
        String surnameStudent = "Surname";
        UUID idSubject = UUID.randomUUID();
        String nameSubject = "SubjectName";
        List<MarkDTO> marksList = new ArrayList<>();

        when(studentService.getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class))).thenReturn(marksList);

        ResponseEntity<List<MarkDTO>> responseEntity = studentController.doGet(idStudent.toString(), surnameStudent, idSubject.toString(), nameSubject);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(marksList, responseEntity.getBody());
        verify(studentService, times(1)).getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class));
    }

}
