package org.example.servlet.subject;

import jakarta.servlet.ServletException;
import org.example.db.ConnectionManager;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.interfaces.StudentRepository;
import org.example.repository.interfaces.SubjectRepository;
import org.example.service.interfaces.StudentService;
import org.example.service.interfaces.SubjectService;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.example.servlet.student.StudentServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class SubjectServletTest {

    private ConnectionManager connectionManager;

    private Connection connection;


    private SubjectRepository<SubjectEntity, UUID> repository;


    private SubjectService<SubjectEntity, UUID> service;

    private SubjectServlet servlet;

    private SubjectDTO studentDTO;

    private HttpServletRequest request;

    private HttpServletResponse response;


    @BeforeEach
    void setUp() throws SQLException {
        service = Mockito.mock(SubjectService.class);
        repository = Mockito.mock(SubjectRepository.class);
        connectionManager = Mockito.mock(ConnectionManager.class);
        connection = Mockito.mock(Connection.class);
        studentDTO = Mockito.mock(SubjectDTO.class);
        servlet = new SubjectServlet(connectionManager);
        servlet.setService(service);

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoPostSuccess() throws IOException, ServletException, SQLException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.saveNewSubject(any(SubjectDTO.class))).thenReturn(true);
        servlet.doPost(request, response);
        verify(response).setStatus(200);

    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfNameNull() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("");
        servlet.doPost(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfSaveNotSuccess() throws IOException, ServletException, SQLException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.deleteSubject(any(SubjectDTO.class))).thenReturn(false);
        servlet.doPost(request, response);
        verify(response).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoPost_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.deleteSubject(any(SubjectDTO.class))).thenThrow(new SQLException());
        servlet.doPost(request, response);
        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
    }


    @Test
    public void testDoDeleteSuccess() throws IOException, SQLException, ServletException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.deleteSubject(any(SubjectDTO.class))).thenReturn(true);
        servlet.doDelete(request, response);
        verify(response).setStatus(200);
    }

    @Test
    public void testDoDelete_shouldReturnBadRequest_IfNameNull() throws IOException, ServletException {
        when(request.getParameter("name")).thenReturn("");
        servlet.doDelete(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoDelete_shouldReturnBadRequest_IfSaveNotSuccess() throws IOException, ServletException, SQLException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.deleteSubject(any(SubjectDTO.class))).thenReturn(false);
        servlet.doDelete(request, response);
        verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoDelete_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("name")).thenReturn("Math");
        when(service.deleteSubject(any(SubjectDTO.class))).thenThrow(new SQLException());

        servlet.doDelete(request, response);

        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
    }


}
