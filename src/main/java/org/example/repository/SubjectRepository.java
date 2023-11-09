package org.example.repository;

import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectEntity, UUID> {

    @Query(value = "SELECT id FROM subject WHERE name = :name",
            nativeQuery = true)
    UUID getSubjectIdByName(@Param("name") String name);

    boolean existsSubjectEntitiesByName(String name);
    @Query(value = "INSERT INTO subject (name) VALUES (:name)",
            nativeQuery = true)
    boolean addNewSubject (@Param("name") String name);

    boolean deleteSubjectEntitiesByName(String name) throws SQLException;

    boolean deleteSubjectEntitiesById(String name);
}
