package org.example.service.interfaces;


import org.example.model.entity.MarkEntity;

import java.util.List;

public interface MarkService {
    MarkEntity findById(Long id);

    List<MarkEntity> findAll();

    MarkEntity save(MarkEntity mark);

    void delete(Long id);
}
