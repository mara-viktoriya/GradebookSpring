package org.example.service.impl;

import org.example.model.entity.MarkEntity;
import org.example.repository.interfaces.MarkRepository;
import org.example.servlet.dto.AddMarkDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MarkServiceImplTest {

    @Mock
    private MarkRepository<MarkEntity, UUID> markRepository;

    private MarkServiceImpl markService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        markService = new MarkServiceImpl(markRepository);
    }

    @Test
    public void testAddMarkSuccess() throws SQLException {
        AddMarkDTO addMarkDTO = new AddMarkDTO(90, "Smith", "Math");

        when(markRepository.save(any(MarkEntity.class))).thenReturn(true);

        boolean added = markService.addMark(addMarkDTO);

        assertTrue(added);
    }

    @Test
    public void testAddMarkFailure() throws SQLException {
        AddMarkDTO addMarkDTO = new AddMarkDTO(90, "Smith", "Math");

        when(markRepository.save(any(MarkEntity.class))).thenReturn(false);

        boolean added = markService.addMark(addMarkDTO);

        assertFalse(added);
    }

    @Test
    public void testGetRepository() {
        MarkRepository<MarkEntity, UUID> repository = markService.getRepository();

        assertNotNull(repository);
        assertEquals(markRepository, repository);
    }
}