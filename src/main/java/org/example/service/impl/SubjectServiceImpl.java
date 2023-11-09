package org.example.service.impl;

import org.example.controller.mapper.MarkMapper;
import org.example.controller.mapper.StudentMapper;
import org.example.model.entity.SubjectEntity;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.example.service.interfaces.SubjectService;
import org.example.controller.dto.SubjectDTO;
import org.example.controller.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.UUID;
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final MarkMapper markMapper;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;
    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, MarkMapper markMapper, StudentMapper studentMapper, SubjectMapper subjectMapper ) {
        this.subjectRepository = subjectRepository;
        this.markMapper = markMapper;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
    }


    @Override
    public SubjectDTO saveNewSubject(SubjectDTO subjectDTO) throws SQLException {
        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);
        if (subjectRepository.existsById(subjectEntity.getId())){
            throw new RuntimeException("Предмет уже существует");
        }
        else {
            SubjectEntity subjectSaved = subjectRepository.save(subjectEntity);
            return subjectMapper.toSubjectDTO(subjectSaved);
        }
    }


    @Override
    public boolean deleteSubject(SubjectDTO subjectDTO) throws SQLException {
        SubjectEntity subjectEntity = subjectMapper.toSubjectEntity(subjectDTO);
        if (!(subjectRepository.existsSubjectEntitiesByName(subjectEntity.getName()))) {
            throw new RuntimeException("Предмет не существует");
        } else {
            return subjectRepository.deleteSubjectEntitiesByName(subjectEntity.getName());
        }
    }

    @Override
    public SubjectRepository getRepository() {
        return this.subjectRepository;
    }

}
