package org.example.controller.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectDTOTest {

    @Test
    void testGettersAndSetters() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkDTO> markList = new ArrayList<>();
        markList.add(new MarkDTO());
        SubjectDTO subject = new SubjectDTO();

        subject.setId(id);
        subject.setName(name);
        subject.setMarkList(markList);

        assertEquals(id, subject.getId());
        assertEquals(name, subject.getName());
        assertEquals(markList, subject.getMarkList());
    }

    @Test
    void testConstructor() {
        UUID id = UUID.randomUUID();
        String name = "Math";
        List<MarkDTO> markList = new ArrayList<>();
        markList.add(new MarkDTO());

        SubjectDTO subject = new SubjectDTO(id, name, markList);

        assertEquals(id, subject.getId());
        assertEquals(name, subject.getName());
        assertEquals(markList, subject.getMarkList());
    }
}
