package org.example.servlet.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AddMarkDTOTest {

    @Test
    void testConstructorAndGetters() {
        AddMarkDTO addMarkDTO = new AddMarkDTO(5, "John", "Math");

        assertEquals(5, addMarkDTO.getMark());
        assertEquals("John", addMarkDTO.getSurname());
        assertEquals("Math", addMarkDTO.getSubject());
    }

    @Test
    void testEmptyConstructorAndSetters() {
        AddMarkDTO addMarkDTO = new AddMarkDTO();

        addMarkDTO.setMark(2);
        addMarkDTO.setSurname("Alice");
        addMarkDTO.setSubject("History");

        assertEquals(2, addMarkDTO.getMark());
        assertEquals("Alice", addMarkDTO.getSurname());
        assertEquals("History", addMarkDTO.getSubject());
    }
}