package org.example.service.impl;

import org.example.model.entity.StudentEntity;
import org.example.repository.repository.StudentRepository;
import org.example.service.interfaces.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity findById(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    //реализовать
    @Override
    public StudentEntity findBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll().toList();
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
