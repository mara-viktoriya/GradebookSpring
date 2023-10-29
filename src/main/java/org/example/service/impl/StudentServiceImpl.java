package org.example.service.impl;

import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.impl.SubjectRepositoryImpl;
import org.example.repository.interfaces.StudentRepository;
import org.example.repository.interfaces.SubjectRepository;
import org.example.service.interfaces.StudentService;
import org.example.service.interfaces.SubjectService;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.example.servlet.mapper.StudentMapper;
import org.example.servlet.mapper.SubjectMapper;

import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class StudentServiceImpl implements StudentService<StudentEntity, UUID> {
    private final StudentRepository<StudentEntity, UUID> studentRepository;

    public StudentServiceImpl(StudentRepository<StudentEntity, UUID> studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public boolean saveNewStudent(StudentDTO studentDTO) throws SQLException, RuntimeException {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toStudentEntity(studentDTO);
        if (studentRepository.isStudentExists(studentEntity)) {
            throw new RuntimeException("Студент уже существует");
        } else {
            return studentRepository.addNewStudent(studentEntity);
        }
    }
    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws SQLException, RuntimeException {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toStudentEntity(studentDTO);
        if (!(studentRepository.isStudentExists(studentEntity))) {
            throw new RuntimeException("Студент не существует");
        } else {
            return studentRepository.deleteStudent(studentEntity);
        }
    }
    //!РЕАЛИЗОВАТЬ
    @Override
    public StudentDTO getMarksBySubject(StudentDTO studentDTO, SubjectDTO subjectDTO) throws SQLException, RuntimeException {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toStudentEntity(studentDTO);
        SubjectEntity subjectEntity = SubjectMapper.INSTANCE.toSubjectEntity(subjectDTO);
        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl(studentRepository.getConnectionManager());
        if (!(studentRepository.isStudentExists(studentEntity))) {
            throw new RuntimeException("Студент не существует");
        } else if (!(subjectRepository.isSubjectExists(subjectEntity))) {
            throw new RuntimeException("Предмет не существует");
        } else {
            studentEntity = studentRepository.getMarksBySubject(studentEntity, subjectEntity);
            return StudentMapper.INSTANCE.toStudentDTO(studentEntity);
        }
    }

    @Override
    public boolean changeStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException, RuntimeException {
        StudentEntity oldStudentEntity = StudentMapper.INSTANCE.toStudentEntity(oldStudentDTO);
        StudentEntity newStudentEntity = StudentMapper.INSTANCE.toStudentEntity(newStudentDTO);
        if (!(studentRepository.isStudentExists(oldStudentEntity))) {
            throw new RuntimeException("Студент не существует");
        } else{
            return studentRepository.changeStudent(oldStudentEntity, newStudentEntity);
        }
    }

    public StudentRepository<StudentEntity, UUID>  getRepository() {
        return this.studentRepository;
    }
}