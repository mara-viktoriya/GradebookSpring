package org.example.repository.repository;


import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.example.model.entity.MarkEntity;


@Repository
public interface MarkRepository extends CrudRepository<MarkEntity, Long> {

}
