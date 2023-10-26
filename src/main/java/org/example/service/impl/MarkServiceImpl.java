package org.example.service.impl;

import org.example.model.entity.MarkEntity;
import org.example.repository.repository.MarkRepository;
import org.example.service.interfaces.MarkService;

import java.util.List;
import java.util.NoSuchElementException;

public class MarkServiceImpl implements MarkService {

    MarkRepository markRepository;

    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public MarkEntity findById(Long id) {
        return markRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<MarkEntity> findAll() {
        return markRepository.findAll().toList();
    }

    @Override
    public MarkEntity save(MarkEntity mark) {
        return markRepository.save(mark);
    }

    @Override
    public void delete(Long id) {
        markRepository.deleteById(id);
    }
}
