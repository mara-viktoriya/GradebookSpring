package org.example.controller.student;


import org.apache.commons.lang3.StringUtils;
import org.example.controller.dto.MarkDTO;
import org.example.controller.dto.StudentDTO;
import org.example.controller.dto.SubjectDTO;
import org.example.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> doPost(@RequestBody StudentDTO studentDTO) {
        try {
            if (StringUtils.isAnyBlank(studentDTO.getId().toString(), studentDTO.getSurname())) {
                throw new RuntimeException("Проверьте корректность введенных данных");
            }
            StudentDTO studentDTOOut = service.saveNewStudent(studentDTO);
            return new ResponseEntity<>(studentDTOOut, HttpStatus.OK);
        } catch (SQLException | RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<StudentDTO> doDelete(@RequestBody StudentDTO studentDTO) {
        try {
            if (StringUtils.isAnyBlank(studentDTO.getId().toString(), studentDTO.getSurname())) {
                throw new RuntimeException("Проверьте корректность введенных данных");
            }
            return new ResponseEntity<>(service.deleteStudent(studentDTO), HttpStatus.OK);
        } catch (SQLException | RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/marks")
    public ResponseEntity<List<MarkDTO>> doGet
            (@RequestParam String idStudent, @RequestParam String surnameStudent, @RequestParam String idSubject, @RequestParam String nameSubject) {
        try {
            if (StringUtils.isAnyBlank(idStudent, idSubject,nameSubject,surnameStudent)) {
                throw new RuntimeException("Проверьте корректность введенных данных");
            }
            StudentDTO studentDTO = new StudentDTO(UUID.fromString(idStudent), surnameStudent);
            SubjectDTO subjectDTO = new SubjectDTO(UUID.fromString(idSubject),nameSubject,new ArrayList<>());
            List<MarkDTO> marksList = service.getMarksBySubject(studentDTO, subjectDTO);
            return new ResponseEntity<>(marksList, HttpStatus.OK);
        } catch (SQLException | RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}



