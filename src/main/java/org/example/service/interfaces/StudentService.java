package org.example.service.interfaces;

import org.example.model.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity findById(Long id);

    StudentEntity findBySurname(String surname);

    List<StudentEntity> findAll();

    StudentEntity save(StudentEntity student);

    void delete(Long id);
}
