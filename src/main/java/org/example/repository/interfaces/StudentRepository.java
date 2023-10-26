package org.example.repository.repository;


import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.example.model.entity.StudentEntity;


@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    StudentEntity findBySurname(String surname);
}
