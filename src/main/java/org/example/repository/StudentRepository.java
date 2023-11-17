package org.example.repository;

import org.example.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    @Query(value = "INSERT INTO student (surname) VALUES (:surname)",
            nativeQuery = true)
    boolean addNewStudent(@Param("surname") String surname);

    @Query(value = "SELECT id FROM student WHERE surname = :surname",
            nativeQuery = true)
    UUID getStudentIDBySurname(@Param("surname") String surname);

}
