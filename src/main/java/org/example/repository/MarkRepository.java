package org.example.repository;

import org.example.model.entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


public interface MarkRepository extends JpaRepository<MarkEntity, UUID> {
//    @Query(value = "INSERT INTO mark (value , student_id, subject_id) VALUES (:value, :student_id, :subject_id)",
//            nativeQuery = true)
//    boolean save( @Param ("value") int value, @Param ("student_id") UUID student_id, @Param ("subject_id") UUID subject_id);
}
