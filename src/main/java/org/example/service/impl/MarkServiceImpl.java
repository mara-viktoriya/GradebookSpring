package org.example.service.impl;

import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.SaveMarkDTO;
import org.example.controller.mapper.MarkMapper;
import org.example.controller.mapper.StudentMapper;
import org.example.controller.mapper.SubjectMapper;
import org.example.model.entity.MarkEntity;
import org.example.repository.MarkRepository;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.example.service.interfaces.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final MarkMapper markMapper;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository, SubjectRepository subjectRepository, StudentRepository studentRepository, MarkMapper markMapper, StudentMapper studentMapper,SubjectMapper subjectMapper ) {
        this.markRepository = markRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.markMapper = markMapper;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;

    }

    @Override
    public MarkDTO save(MarkDTO markDTO) {
        MarkEntity markEntity = markMapper.toMarkEntity(markDTO);
        if (!(subjectRepository.existsById(markEntity.getSubject().getId()))){
            throw new RuntimeException("предмет не существует");
        }
        if (!(studentRepository.existsById(markEntity.getStudent().getId()))) {
            throw new RuntimeException("студент не существует");
        }

        return markMapper.toMarkDTO(markRepository.save(markEntity));
    }


    @Override
    public MarkRepository getRepository() {
        return this.markRepository;
    }
}
