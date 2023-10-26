package org.example.service.interfaces;

import org.example.model.entity.SubjectEntity;

import java.util.List;

public interface SubjectService {
    SubjectEntity findById(Long id);

    List<SubjectEntity> findAll();

    SubjectEntity save(SubjectEntity subject);

    void delete(Long id);
}
