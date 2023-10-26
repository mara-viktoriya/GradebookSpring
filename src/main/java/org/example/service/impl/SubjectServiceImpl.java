package org.example.service.impl;

import org.example.model.entity.SubjectEntity;
import org.example.repository.repository.SubjectRepository;
import org.example.service.interfaces.SubjectService;

import java.util.List;
import java.util.NoSuchElementException;

public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public SubjectEntity findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<SubjectEntity> findAll() {
        return subjectRepository.findAll().toList();
    }

    @Override
    public SubjectEntity save(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}
