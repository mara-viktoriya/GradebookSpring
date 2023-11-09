package org.example.controller.subject;

import jakarta.servlet.ServletException;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/subject")

public class SubjectController{
    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> doPost(@RequestBody SubjectDTO subjectDTO) {
        try {
            return new ResponseEntity<>(service.saveNewSubject(subjectDTO), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{name}")
    public ResponseEntity<SubjectDTO> doDelete(@PathVariable String name) throws ServletException, IOException {
        if (StringUtils.isBlank(name)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setName(name);
                boolean deleted = service.deleteSubject(subjectDTO);
                if (deleted) {
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
