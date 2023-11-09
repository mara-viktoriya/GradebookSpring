package org.example.service.impl;

import org.example.controller.mapper.MarkMapper;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.example.service.interfaces.StudentService;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.controller.mapper.StudentMapper;
import org.example.controller.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private final MarkMapper markMapper;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, MarkMapper markMapper, StudentMapper studentMapper, SubjectMapper subjectMapper) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.markMapper = markMapper;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public StudentDTO saveNewStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);
        if (studentRepository.existsById(studentEntity.getId())) {
            throw new RuntimeException("Студент уже существует");
        } else {
            StudentEntity studentEntitySaved = studentRepository.save(studentEntity);
            return studentMapper.toStudentDTO(studentEntitySaved);
        }
    }

    @Override
    public StudentDTO deleteStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);
        if (!(studentRepository.existsById(studentEntity.getId()))) {
            throw new RuntimeException("Студент не существует");
        } else {
            studentRepository.delete(studentEntity);
            return studentDTO;
        }
    }

//    @Override
//    public List<Long> getMarksBySubject(StudentDTO studentDTO, SubjectDTO subjectDTO) throws SQLException, RuntimeException {
//        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);
//        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);
//        if (!(studentRepository.existsStudentEntityBySurname(studentEntity.getSurname()))) {
//            throw new RuntimeException("Студент не существует");
//        } else if (!(subjectRepository.existsSubjectEntitiesByName(subjectEntity.getName()))) {
//            throw new RuntimeException("Предмет не существует");
//        } else {
//            return studentRepository.getMarksBySubject(studentEntity.getSurname(), subjectEntity.getName());
//        }
//    }

    public StudentRepository getRepository() {
        return this.studentRepository;
    }
}