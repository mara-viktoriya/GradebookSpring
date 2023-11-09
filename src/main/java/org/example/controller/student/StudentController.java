package org.example.controller.student;


import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.example.controller.dto.StudentDTO;
import org.example.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@RestController
@RequestMapping("/student")
public class StudentController{
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> doPost(@RequestBody StudentDTO studentDTO) {
        try {
            if (StringUtils.isAnyBlank(studentDTO.getId().toString(), studentDTO.getSurname())){
                throw new RuntimeException();
            }
            StudentDTO studentDTOOut = service.saveNewStudent(studentDTO);
            return new ResponseEntity<>(studentDTOOut, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<StudentDTO> doDelete(@RequestBody StudentDTO studentDTO) {
        try {
            if (StringUtils.isAnyBlank(studentDTO.getId().toString(), studentDTO.getSurname())){
                throw new RuntimeException();
            }
            return new ResponseEntity<>(service.deleteStudent(studentDTO), HttpStatus.OK);
            } catch (SQLException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    //    @GetMapping("/marks)")
//    public ResponseEntity<List<Long>> doGet(@RequestParam String surname, @RequestParam String subject) throws ServletException, IOException {
//        if (StringUtils.isAnyBlank(surname, subject)) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            try {
//                StudentDTO studentDtoOutgoing = new StudentDTO();
//                studentDtoOutgoing.setSurname(surname);
//                SubjectDTO subjectDtoOutgoing = new SubjectDTO();
//                subjectDtoOutgoing.setName(subject);
//                List<Long> marksList = service.getMarksBySubject(studentDtoOutgoing, subjectDtoOutgoing);
//                return new ResponseEntity<>(marksList, HttpStatus.OK);
//            } catch (SQLException e) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            } catch (RuntimeException e) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//
//        }
//    }

