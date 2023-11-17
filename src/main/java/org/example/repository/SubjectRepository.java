package org.example.repository;

import org.example.model.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectEntity, UUID> {

}
