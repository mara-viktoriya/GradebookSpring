package org.example.repository;

import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    @Query(value = "INSERT INTO student (surname) VALUES (:surname)",
            nativeQuery = true)
    boolean addNewStudent(@Param("surname") String surname);

    @Query(value = "SELECT id FROM student WHERE surname = :surname",
            nativeQuery = true)
    UUID getStudentIDBySurname(@Param("surname") String surname);

    boolean existsStudentEntityBySurname(String surname);

    boolean deleteStudentEntityBySurname(String surname);

    boolean deleteStudentEntityById(UUID uuid);

    boolean existsStudentEntityById(UUID uuid);

//    @Query(value = "SELECT value FROM mark JOIN subject s ON mark.subject_id = s.id WHERE student_id = (SELECT id FROM student WHERE surname = :surname) and subject_id = (SELECT id FROM subject WHERE name = :subjectName)",
//            nativeQuery = true)
//    List<Long> getMarksBySubject(@Param(":surname") String surname, @Param(":subjectName") String subjectName);

}
