package org.example.controller.mark;

import jakarta.validation.Valid;
import org.example.controller.dto.MarkDTO;
import org.example.service.interfaces.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private final MarkService service;
    @Autowired
    public MarkController(MarkService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MarkDTO> doPost(@RequestBody MarkDTO markDTO) {
        try {
            return new ResponseEntity<>(service.save(markDTO), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
