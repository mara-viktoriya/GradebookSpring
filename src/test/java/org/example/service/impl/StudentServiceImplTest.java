package org.example.service.impl;

import org.example.db.ConnectionManager;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.StudentRepository;
import org.example.repository.interfaces.SubjectRepository;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {

    private ConnectionManager connectionManager;

    private Connection connection;
    private StudentRepository<StudentEntity, UUID> studentRepository;
    private SubjectRepository<SubjectEntity, UUID> subjectRepository;
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setup() {
        studentRepository = Mockito.mock(StudentRepository.class);
        subjectRepository = Mockito.mock(SubjectRepository.class);
        connectionManager = Mockito.mock(ConnectionManager.class);
        connection = Mockito.mock(Connection.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void testSaveNewStudentSuccess() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(false);
        when(studentRepository.addNewStudent(any(StudentEntity.class))).thenReturn(true);

        boolean added = studentService.saveNewStudent(studentDTO);

        assertTrue(added);
    }

    @Test
    public void testSaveNewStudentAlreadyExists() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(true);

        assertThrows(RuntimeException.class, () -> studentService.saveNewStudent(studentDTO));
    }

    @Test
    public void testDeleteStudentSuccess() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");
        StudentEntity studentEntity = new StudentEntity(UUID.randomUUID(), "John", null, null);

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(true);
        when(studentRepository.deleteStudent(any(StudentEntity.class))).thenReturn(true);

        boolean deleted = studentService.deleteStudent(studentDTO);

        assertTrue(deleted);
    }

    @Test
    public void testDeleteStudentNotExists() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(false);

        assertThrows(RuntimeException.class, () -> studentService.deleteStudent(studentDTO));
    }

    @Test
    public void testGetMarksBySubjectStudentNotExists() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(false);

        assertThrows(RuntimeException.class, () -> studentService.getMarksBySubject(studentDTO, subjectDTO));
    }

    @Test
    public void testGetMarksBySubjectSubjectNotExists() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        StudentEntity studentEntity = new StudentEntity(UUID.randomUUID(), "John", null, null);

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(true);

        when(subjectRepository.isSubjectExists(any(SubjectEntity.class))).thenReturn(false);

        assertThrows(RuntimeException.class, () -> studentService.getMarksBySubject(studentDTO, subjectDTO));
    }

    @Test
    public void testChangeStudentSuccess() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO.setSurname("Jane");
        StudentEntity oldStudentEntity = new StudentEntity(UUID.randomUUID(), "John", null, null);
        StudentEntity newStudentEntity = new StudentEntity(UUID.randomUUID(), "Jane", null, null);

        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(true);
        when(studentRepository.changeStudent(any(StudentEntity.class), any(StudentEntity.class)))
                .thenReturn(true);

        boolean changed = studentService.changeStudent(studentDTO, studentDTO2);

        assertTrue(changed);
    }

    @Test
    public void testChangeStudentStudentNotExists() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSurname("John");
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO.setSurname("Jane");
        when(studentRepository.isStudentExists(any(StudentEntity.class))).thenReturn(false);
        assertThrows(RuntimeException.class, () -> studentService.changeStudent(studentDTO, studentDTO2));
    }

    @Test
    public void testGetRepository() {
        StudentRepository<StudentEntity, UUID> repository = studentService.getRepository();
        assertNotNull(repository);
        assertEquals(studentRepository, repository);
    }
}