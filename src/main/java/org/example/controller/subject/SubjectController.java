package org.example.controller.subject;

import org.apache.commons.lang3.StringUtils;
import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")

public class SubjectController {
    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> doPost(@RequestBody SubjectDTO subjectDTO) {
        try {
            if (StringUtils.isAnyBlank(subjectDTO.getId().toString(), subjectDTO.getName())) {
                throw new RuntimeException("Проверьте корректность введенных данных");
            }
            return new ResponseEntity<>(service.saveNewSubject(subjectDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping
    public ResponseEntity<SubjectDTO> doDelete(@RequestBody SubjectDTO subjectDTO) {

        try {
            if (StringUtils.isAnyBlank(subjectDTO.getId().toString(), subjectDTO.getName())) {
                throw new RuntimeException("Проверьте корректность введенных данных");
            }
            return new ResponseEntity<>(service.deleteSubject(subjectDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

