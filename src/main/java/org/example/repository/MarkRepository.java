package org.example.repository;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;


public interface MarkRepository extends JpaRepository<MarkEntity, UUID> {

    List<MarkEntity> getMarkEntitiesByStudent_IdAndSubjectId(UUID uuidStudent, UUID uuidSubject);
}
