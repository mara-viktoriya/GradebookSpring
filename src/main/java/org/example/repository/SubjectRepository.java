package org.example.repository;

import org.example.model.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectEntity, UUID> {

    @Query(value = "SELECT id FROM subject WHERE name = :name",
            nativeQuery = true)
    UUID getSubjectIdByName(@Param("name") String name);
    @Query(value = "INSERT INTO subject (name) VALUES (:name)",
            nativeQuery = true)
    boolean addNewSubject (@Param("name") String name);

}
