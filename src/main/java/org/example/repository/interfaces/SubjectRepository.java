package org.example.repository.repository;


import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.example.model.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends CrudRepository<SubjectEntity, Long> {
}
