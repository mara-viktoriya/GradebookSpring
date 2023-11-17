package org.example.repository;

import org.example.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

}
