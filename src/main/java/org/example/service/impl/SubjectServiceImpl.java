package org.example.service.impl;

import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.SubjectRepository;
import org.example.service.interfaces.SubjectService;
import org.example.servlet.dto.SubjectDTO;
import org.example.servlet.mapper.StudentMapper;
import org.example.servlet.mapper.SubjectMapper;

import java.sql.SQLException;
import java.util.UUID;

public class SubjectServiceImpl implements SubjectService<SubjectEntity, UUID> {

    private final SubjectRepository<SubjectEntity, UUID > subjectRepository;

    public SubjectServiceImpl(SubjectRepository<SubjectEntity, UUID> subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public boolean saveNewSubject(SubjectDTO subjectDTO) throws SQLException {
        SubjectEntity subjectEntity = SubjectMapper.INSTANCE.toSubjectEntity(subjectDTO);
        return subjectRepository.addNewSubject(subjectEntity);
    }

    @Override
    public boolean deleteSubject(SubjectDTO subjectDTO) throws SQLException {
        SubjectEntity subjectEntity = SubjectMapper.INSTANCE.toSubjectEntity(subjectDTO);
        if (!(subjectRepository.isSubjectExists(subjectEntity))) {
            throw new RuntimeException("Студент не существует");
        } else {
            return subjectRepository.deleteSubject(subjectEntity);
        }
    }

}
