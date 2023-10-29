package org.example.servlet.mark;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.ConnectionManager;
import org.example.model.entity.MarkEntity;
import org.example.repository.interfaces.MarkRepository;
import org.example.service.interfaces.MarkService;
import org.example.servlet.dto.AddMarkDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MarkServletTest {

    @Mock
    private ConnectionManager connectionManager;

    @Mock
    private MarkRepository<MarkEntity, UUID> markRepository;

    @Mock
    private MarkService<MarkEntity, UUID> markService;

    @InjectMocks
    private MarkServlet servlet;

//    @Test
//    void testDefaultConstructor() throws Exception {
//        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//        StringWriter stringWriter = new StringWriter();
//        Mockito.when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
//
//        servlet.doPost(request, response);
//
//        Assertions.assertFalse(stringWriter.toString().isEmpty(), "Response body should not be empty");
//
//        Mockito.verify(response).setStatus(HttpServletResponse.SC_OK);
//    }
//
//    @Test
//    public void testDoPostSuccess() throws IOException, ServletException, SQLException {
//        when(request.getParameter("mark")).thenReturn("90");
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(markService.addMark(any(AddMarkDTO.class))).thenReturn(true);
//
//        servlet.doPost(request, response);
//
//        verify(markService, times(1)).addMark(any(AddMarkDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoPostBadRequest() throws IOException, ServletException, SQLException {
//        when(request.getParameter("mark")).thenReturn("invalidMark");
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(markService.addMark(any(AddMarkDTO.class))).thenReturn(false);
//
//        servlet.doPost(request, response);
//
//        verify(markService, times(1)).addMark(any(AddMarkDTO.class));
//        assertEquals(400, response.getStatus());
//    }
//
//    @Test
//    public void testDoPostError() throws IOException, ServletException, SQLException {
//        when(request.getParameter("mark")).thenReturn("90");
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        //when(markService.addMark(any(AddMarkDTO.class)).thenThrow());
//
//        servlet.doPost(request, response);
//
//        verify(markService, times(1)).addMark(any(AddMarkDTO.class));
//        assertEquals(400, response.getStatus());
//    }
//
//    private static class TestWriter extends PrintWriter {
//        public TestWriter() {
//            super(new StringWriter());
//        }
//    }
}