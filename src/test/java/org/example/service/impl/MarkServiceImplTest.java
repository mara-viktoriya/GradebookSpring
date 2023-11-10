package org.example.service.impl;


//import org.example.controller.dto.MarkDTO;
//import org.example.controller.dto.StudentDTO;
//import org.example.controller.dto.SubjectDTO;
//import org.example.controller.mapper.MarkMapper;
//import org.example.controller.mapper.StudentMapper;
//import org.example.controller.mapper.SubjectMapper;
//import org.example.model.entity.MarkEntity;
//import org.example.model.entity.StudentEntity;
//import org.example.model.entity.SubjectEntity;
//import org.example.repository.MarkRepository;
//import org.example.repository.StudentRepository;
//import org.example.repository.SubjectRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//public class MarkServiceImplTest {
//    @InjectMocks
//    MarkServiceImpl markServiceImpl;
//
//    @Mock
//    private  MarkRepository markRepository;
//    @Mock
//    private  SubjectRepository subjectRepository;
//    @Mock
//    private  StudentRepository studentRepository;
//    @Mock
//    private  MarkMapper markMapper;
//    @Mock
//    private  StudentMapper studentMapper;
//    @Mock
//    private  SubjectMapper subjectMapper;
//
//    @Test
//    public void test_save_valid_markDTO_successfully() {
//        // Arrange
//        MarkDTO markDTO = new MarkDTO();
//        markDTO.setId(UUID.randomUUID());
//        markDTO.setValue(8);
//        SubjectDTO subjectDTO = new SubjectDTO();
//        subjectDTO.setId(UUID.randomUUID());
//        markDTO.setSubject(subjectDTO);
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(UUID.randomUUID());
//        markDTO.setStudent(studentDTO);
//
//        MarkEntity markEntity = new MarkEntity();
//        markEntity.setId(markDTO.getId());
//        markEntity.setValue(markDTO.getValue());
//        SubjectEntity subjectEntity = new SubjectEntity();
//        subjectEntity.setId(markDTO.getSubject().getId());
//        markEntity.setSubject(subjectEntity);
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(markDTO.getStudent().getId());
//        markEntity.setStudent(studentEntity);
//
//        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
//        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(true);
//        when(studentRepository.existsById(markEntity.getStudent().getId())).thenReturn(true);
//
//        // Act
//        MarkDTO result = markServiceImpl.save(markDTO);
//
//        // Assert
//        assertEquals(markDTO, result);
//    }
//
//    // throw an exception if the subject does not exist
//    @Test
//    public void test_throw_exception_if_subject_does_not_exist() {
//        // Arrange
//        MarkDTO markDTO = new MarkDTO();
//        markDTO.setId(UUID.randomUUID());
//        markDTO.setValue(8);
//        SubjectDTO subjectDTO = new SubjectDTO();
//        subjectDTO.setId(UUID.randomUUID());
//        markDTO.setSubject(subjectDTO);
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(UUID.randomUUID());
//        markDTO.setStudent(studentDTO);
//
//        MarkEntity markEntity = new MarkEntity();
//        markEntity.setId(markDTO.getId());
//        markEntity.setValue(markDTO.getValue());
//        SubjectEntity subjectEntity = new SubjectEntity();
//        subjectEntity.setId(markDTO.getSubject().getId());
//        markEntity.setSubject(subjectEntity);
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(markDTO.getStudent().getId());
//        markEntity.setStudent(studentEntity);
//
//        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
//        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(false);
//
//        // Act & Assert
//        assertThrows(RuntimeException.class, () -> markServiceImpl.save(markDTO));
//    }
//
//    // throw an exception if the student does not exist
//    @Test
//    public void test_throw_exception_if_student_does_not_exist() {
//        // Arrange
//        MarkDTO markDTO = new MarkDTO();
//        markDTO.setId(UUID.randomUUID());
//        markDTO.setValue(8);
//        SubjectDTO subjectDTO = new SubjectDTO();
//        subjectDTO.setId(UUID.randomUUID());
//        markDTO.setSubject(subjectDTO);
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(UUID.randomUUID());
//        markDTO.setStudent(studentDTO);
//
//        MarkEntity markEntity = new MarkEntity();
//        markEntity.setId(markDTO.getId());
//        markEntity.setValue(markDTO.getValue());
//        SubjectEntity subjectEntity = new SubjectEntity();
//        subjectEntity.setId(markDTO.getSubject().getId());
//        markEntity.setSubject(subjectEntity);
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(markDTO.getStudent().getId());
//        markEntity.setStudent(studentEntity);
//
//        when(markMapper.toMarkEntity(markDTO)).thenReturn(markEntity);
//        when(subjectRepository.existsById(markEntity.getSubject().getId())).thenReturn(true);
//        when(studentRepository.existsById(markEntity.getStudent().getId())).thenReturn(false);
//
//        // Act & Assert
//        assertThrows(RuntimeException.class, () -> markServiceImpl.save(markDTO));
//    }
//
//    // save a markDTO with a null subject
//    @Test
//    public void test_save_markDTO_with_null_subject() {
//        // Arrange
//        MarkDTO markDTO = new MarkDTO();
//        markDTO.setId(UUID.randomUUID());
//        markDTO.setValue(8);
//        markDTO.setSubject(null);
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(UUID.randomUUID());
//        markDTO.setStudent(studentDTO);
//
//        // Act & Assert
//        assertThrows(NullPointerException.class, () -> markServiceImpl.save(markDTO));
//    }
//
//}