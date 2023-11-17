package org.example.repository;

import org.example.model.entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface MarkRepository extends JpaRepository<MarkEntity, UUID> {

    List<MarkEntity> getMarkEntitiesByStudent_IdAndSubjectId(UUID uuidStudent, UUID uuidSubject);
}
