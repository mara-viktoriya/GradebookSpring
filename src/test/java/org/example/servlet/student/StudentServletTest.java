package org.example.servlet.student;

import org.example.db.ConnectionManager;
import org.example.model.entity.StudentEntity;
import org.example.repository.interfaces.StudentRepository;
import org.example.service.interfaces.StudentService;
import org.example.servlet.dto.MarkDTO;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServletTest {

    private ConnectionManager connectionManager;

    private Connection connection;


    private StudentRepository<StudentEntity, UUID> repository;


    private StudentService<StudentEntity, UUID> service;

    private StudentServlet servlet;

    private StudentDTO studentDTO;

    private HttpServletRequest request;

    private HttpServletResponse response;


    @BeforeEach
    void setUp() throws SQLException {
        service = Mockito.mock(StudentService.class);
        repository = Mockito.mock(StudentRepository.class);
        connectionManager = Mockito.mock(ConnectionManager.class);
        connection = Mockito.mock(Connection.class);
        studentDTO = Mockito.mock(StudentDTO.class);
        servlet = new StudentServlet(connectionManager);
        servlet.setService(service);

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoPostSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn("Mockito");
        when(service.saveNewStudent(any(StudentDTO.class))).thenReturn(true);
        servlet.doPost(request, response);
        Mockito.verify(response).setStatus(200);
    }

    @Test
    public void testDoPost_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("surname")).thenReturn("Mockito");
        when(service.saveNewStudent(any(StudentDTO.class))).thenThrow(new SQLException());
        servlet.doPost(request, response);
        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfSurnameNull() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn(null);
        servlet.doPost(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPost_shouldReturnBadRequest_IfSaveNotSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn("Mockito");
        when(service.saveNewStudent(any(StudentDTO.class))).thenReturn(false);
        servlet.doPost(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPutSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("old-surname")).thenReturn("OldSmith");
        when(request.getParameter("new-surname")).thenReturn("NewSmith");
        when(service.changeStudent(any(StudentDTO.class), any(StudentDTO.class))).thenReturn(true);
        servlet.doPut(request, response);
        Mockito.verify(response).setStatus(200);
    }

    @Test
    public void testDoPut_shouldReturnBadRequest_IfSurnameNull() throws ServletException, IOException {
        when(request.getParameter("old-surname")).thenReturn("");
        when(request.getParameter("new-surname")).thenReturn("NewSmith");

        servlet.doPut(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPut_shouldReturnBadRequest_IfChangeStudentNotSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("old-surname")).thenReturn("OldSmith");
        when(request.getParameter("new-surname")).thenReturn("NewSmith");
        when(service.changeStudent(any(StudentDTO.class), any(StudentDTO.class))).thenReturn(false);
        servlet.doPut(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoPut_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("old-surname")).thenReturn("OldSmith");
        when(request.getParameter("new-surname")).thenReturn("NewSmith");
        when(service.changeStudent(any(StudentDTO.class), any(StudentDTO.class))).thenThrow(new SQLException());
        servlet.doPut(request, response);
        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoDeleteSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn("OldSmith");
        when(service.deleteStudent(any(StudentDTO.class))).thenReturn(true);
        servlet.doDelete(request, response);
        Mockito.verify(response).setStatus(200);
    }

    @Test
    public void testDoDelete_shouldReturnBadRequest_IfDeleteStudentNotSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn("OldSmith");
        when(service.deleteStudent(any(StudentDTO.class))).thenReturn(false);
        servlet.doDelete(request, response);
        Mockito.verify(response).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoDelete_shouldReturnBadRequest_IfSurnameNull() throws SQLException, ServletException, IOException {
        when(request.getParameter("surname")).thenReturn("");
        servlet.doDelete(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }

    @Test
    public void testDoDelete_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("surname")).thenReturn("Mockito");
        when(service.deleteStudent(any(StudentDTO.class))).thenThrow(new SQLException());
        servlet.doDelete(request, response);
        verify(response).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoGetSuccess() throws ServletException, IOException, SQLException {
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        List<MarkDTO> markDTOList = new ArrayList<>();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        MarkDTO markDTO = new MarkDTO();
        markDTO.setValue(5);
        markDTOList.add(markDTO);
        when(service.getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class)))
                .thenReturn(new StudentDTO(UUID.randomUUID(), "Smith", markDTOList, subjectDTOList));

        servlet.doGet(request, response);
        verify(response).setStatus(200);
        Assertions.assertEquals(stringWriter.getBuffer().toString(), "Оценки Smith по предмету Math : 5 ");
    }

    @Test
    public void testDoGet_shouldThrowException() throws IOException, SQLException, ServletException {
        when(request.getParameter("surname")).thenReturn("Smith");
        when(request.getParameter("subject")).thenReturn("Math");
        when(service.getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class)))
                .thenThrow(new SQLException());

        servlet.doGet(request, response);
        verify(response).sendError(400, "Ошибка работы базы данных");
    }

    @Test
    public void testDoGet_shouldReturnBadRequest_IfSurnameNull() throws ServletException, IOException {
        when(request.getParameter("surname")).thenReturn("");
        when(request.getParameter("subject")).thenReturn("Math");
        servlet.doGet(request, response);
        Mockito.verify(response).sendError(400, "Проверьте корректность введенных данных");
    }
}