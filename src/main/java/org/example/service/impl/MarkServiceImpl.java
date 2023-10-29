package org.example.service.impl;

import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.MarkRepository;
import org.example.service.interfaces.MarkService;
import org.example.servlet.dto.AddMarkDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class MarkServiceImpl implements MarkService<MarkEntity, UUID> {
    private final MarkRepository<MarkEntity, UUID> markRepository;

    public MarkServiceImpl(MarkRepository<MarkEntity, UUID> markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public boolean addMark(AddMarkDTO addMarkDTO) throws SQLException {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setSurname(addMarkDTO.getSurname());
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(addMarkDTO.getSubject());
        MarkEntity markEntity = new MarkEntity(UUID.randomUUID(), addMarkDTO.getMark(), studentEntity, subjectEntity);
        return markRepository.save(markEntity);
    }

    @Override
    public MarkRepository<MarkEntity, UUID>  getRepository() {
        return this.markRepository;
    }
}
