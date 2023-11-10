package org.example.controller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkDTO> markList = new ArrayList<>();
        markList.add(new MarkDTO());
        SubjectDTO subject = new SubjectDTO();

        // Act
        subject.setId(id);
        subject.setName(name);
        subject.setMarkList(markList);

        // Assert
        assertEquals(id, subject.getId());
        assertEquals(name, subject.getName());
        assertEquals(markList, subject.getMarkList());
    }

    @Test
    void testConstructor() {
        // Arrange
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkDTO> markList = new ArrayList<>();
        markList.add(new MarkDTO());

        // Act
        SubjectDTO subject = new SubjectDTO(id, name, markList);

        // Assert
        assertEquals(id, subject.getId());
        assertEquals(name, subject.getName());
        assertEquals(markList, subject.getMarkList());
    }
}
