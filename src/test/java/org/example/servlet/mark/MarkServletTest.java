package org.example.servlet.mark;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.ConnectionManager;
import org.example.model.entity.MarkEntity;
import org.example.repository.interfaces.MarkRepository;
import org.example.service.interfaces.MarkService;
import org.example.servlet.dto.AddMarkDTO;
import org.example.servlet.dto.MarkDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MarkServletTest {

    private ConnectionManager connectionManager;
    private Connection connection;
    private MarkRepository<MarkEntity, UUID> repository;
    private MarkService<MarkEntity, UUID> service;
    private MarkServlet servlet;
    private MarkDTO markDTO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @BeforeEach
    void setUp() throws SQLException {
        service = Mockito.mock(MarkService.class);
        repository = Mockito.mock(MarkRepository.class);
        connectionManager = Mockito.mock(ConnectionManager.class);
        connection = Mockito.mock(Connection.class);
        markDTO = Mockito.mock(MarkDTO.class);
        servlet = new MarkServlet(connectionManager);
        servlet.setService(service);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoPostSuccess() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("5");
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        when(service.addMark(any(AddMarkDTO.class))).thenReturn(true);
        servlet.doPost(request, response);
        verify(response).setStatus(200);
    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfValueNull() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("");
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        servlet.doPost(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }
    @Test
    public void testDoPost_shouldReturnBadRequest_IfSurnameNull() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("5");
        when(request.getParameter("surname")).thenReturn("");
        when(request.getParameter("subject")).thenReturn("Math");
        servlet.doPost(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfNameNull() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("5");
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("");
        servlet.doPost(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }
    @Test
    public void testDoPost_shouldReturnBadRequest_IfAddedNotSuccess() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("5");
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        when(service.addMark(any(AddMarkDTO.class))).thenReturn(false);
        servlet.doPost(request, response);
        verify(response).sendError(400, "Значение не добавлено.Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPost_shouldThrowException() throws IOException, ServletException, SQLException {
        when(request.getParameter("mark")).thenReturn("5");
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        when(service.addMark(any(AddMarkDTO.class))).thenThrow(new SQLException());
        servlet.doPost(request, response);
        verify(response).sendError(400, "Ошибка работы базы данных");
    }
}