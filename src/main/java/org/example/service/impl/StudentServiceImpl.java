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
import org.example.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private final MarkRepository markRepository;

    private final ListMarkMapper listMarkMapper;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, SubjectRepository subjectRepository, ListMarkMapper listMarkMapper, StudentMapper studentMapper, SubjectMapper subjectMapper, MarkRepository markRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.markRepository = markRepository;
        this.listMarkMapper = listMarkMapper;
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

    @Override
    public List<MarkDTO> getMarksBySubject(StudentDTO studentDTO, SubjectDTO subjectDTO) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDTO);
        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);
        if (!(studentRepository.existsById(studentEntity.getId()))) {
            throw new RuntimeException("Студент не существует");
        } else if (!(subjectRepository.existsById(subjectEntity.getId()))) {
            throw new RuntimeException("Предмет не существует");
        } else {
            List <MarkEntity> markEntityList= markRepository.getMarkEntitiesByStudent_IdAndSubjectId(studentEntity.getId(), subjectDTO.getId());
            return listMarkMapper.toMarkDTOList(markEntityList);
        }
    }

    public StudentRepository getRepository() {
        return this.studentRepository;
    }
}