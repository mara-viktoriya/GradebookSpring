//package org.example.servlet.student;
//
//import org.example.db.ConnectionManager;
//import org.example.model.entity.StudentEntity;
//import org.example.repository.interfaces.StudentRepository;
//import org.example.service.interfaces.StudentService;
//import org.example.servlet.dto.MarkDTO;
//import org.example.servlet.dto.StudentDTO;
//import org.example.servlet.dto.SubjectDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.Mockito.*;
//
//public class StudentServletTest {
//
//    @Mock
//    private ConnectionManager connectionManager;
//
//
//    @Mock
//    private StudentRepository<StudentEntity, UUID> studentRepository;
//
//    @Mock
//    private StudentService<StudentEntity, UUID> studentService;
//
//    @Mock
//    private HttpServletRequest request;
//
//    @Mock
//    private HttpServletResponse response;
//
//    @Mock
//    private RequestDispatcher requestDispatcher;
//
//    private StudentServlet studentServlet;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        studentServlet = new StudentServlet(connectionManager, studentRepository, studentService);
//    }
//
//    @Test
//    public void testDoGetSuccess() throws ServletException, IOException, SQLException {
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        List<MarkDTO> markDTOList = new ArrayList<>();
//        markDTOList.add(new MarkDTO(90));
//        when(studentService.getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class)))
//                .thenReturn(new StudentDTO("Smith", markDTOList));
//
//        studentServlet.doGet(request, response);
//
//        verify(studentService, times(1)).getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoGetBadRequest() throws ServletException, IOException {
//        when(request.getParameter("surname")).thenReturn("");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        studentServlet.doGet(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных данных");
//    }
//
//    @Test
//    public void testDoGetError() throws ServletException, IOException, SQLException {
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(request.getParameter("subject")).thenReturn("Math");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.getMarksBySubject(any(StudentDTO.class), any(SubjectDTO.class))
//                .thenThrow(new SQLException("Database Error")));
//
//        studentServlet.doGet(request, response);
//
//        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
//    }
//
//    @Test
//    public void testDoPostSuccess() throws ServletException, IOException {
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.saveNewStudent(any(StudentDTO.class)).thenReturn(true));
//
//        studentServlet.doPost(request, response);
//
//        verify(studentService, times(1)).saveNewStudent(any(StudentDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoPostBadRequest() throws ServletException, IOException {
//        when(request.getParameter("surname")).thenReturn("");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        studentServlet.doPost(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных данных");
//    }
//
//    @Test
//    public void testDoPostError() throws ServletException, IOException, SQLException {
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.saveNewStudent(any(StudentDTO.class)).thenThrow(new SQLException("Database Error")));
//
//        studentServlet.doPost(request, response);
//
//        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
//    }
//
//    @Test
//    public void testDoPutSuccess() throws ServletException, IOException {
//        when(request.getParameter("old-surname")).thenReturn("OldSmith");
//        when(request.getParameter("new-surname")).thenReturn("NewSmith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.changeStudent(any(StudentDTO.class), any(StudentDTO.class)).thenReturn(true));
//
//        studentServlet.doPut(request, response);
//
//        verify(studentService, times(1)).changeStudent(any(StudentDTO.class), any(StudentDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoPutBadRequest() throws ServletException, IOException {
//        when(request.getParameter("old-surname")).thenReturn("");
//        when(request.getParameter("new-surname")).thenReturn("NewSmith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        studentServlet.doPut(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных данных");
//    }
//
//    @Test
//    public void testDoPutError() throws ServletException, IOException, SQLException {
//        when(request.getParameter("old-surname")).thenReturn("OldSmith");
//        when(request.getParameter("new-surname")).thenReturn("NewSmith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.changeStudent(any(StudentDTO.class), any(StudentDTO.class))
//                .thenThrow(new SQLException("Database Error")));
//
//        studentServlet.doPut(request, response);
//
//        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
//    }
//
//    @Test
//    public void testDoDeleteSuccess() throws ServletException, IOException {
//        when(request.getParameter("surname")).thenReturn("Smith");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        when(studentService.deleteStudent(any(StudentDTO.class)).thenReturn(true));
//
//        studentServlet.doDelete(request, response);
//
//        verify(studentService, times(1)).deleteStudent(any(StudentDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoDeleteBadRequest() throws ServletException, IOException {
//        when(request.getParameter("surname")).thenReturn("");
//        when(response.getWriter()).thenReturn(new TestWriter());
//
//        studentServlet.doDelete(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных");
//    }
//}