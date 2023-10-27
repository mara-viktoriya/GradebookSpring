//package org.example.servlet.subject;
//
//import jakarta.servlet.ServletException;
//import org.example.db.ConnectionManager;
//import org.example.model.entity.SubjectEntity;
//import org.example.repository.interfaces.SubjectRepository;
//import org.example.service.interfaces.SubjectService;
//import org.example.servlet.dto.SubjectDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.UUID;
//
//import static org.mockito.Mockito.*;
//
//public class SubjectServletTest {
//
//    @Mock
//    private ConnectionManager connectionManager;
//
//    @Mock
//    private SubjectRepository<SubjectEntity, UUID> subjectRepository;
//
//    @Mock
//    private SubjectService<SubjectEntity, UUID> subjectService;
//
//    @Mock
//    private HttpServletRequest request;
//
//    @Mock
//    private HttpServletResponse response;
//
//    private SubjectServlet subjectServlet;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        subjectServlet = new SubjectServlet(connectionManager, subjectRepository, subjectService);
//    }
//
//    @Test
//    public void testDoPostSuccess() throws IOException, ServletException, SQLException {
//        when(request.getParameter("name")).thenReturn("Math");
//        when(subjectService.saveNewSubject(any(SubjectDTO.class))).thenReturn(true);
//
//        subjectServlet.doPost(request, response);
//
//        verify(subjectService, times(1)).saveNewSubject(any(SubjectDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoPostBadRequest() throws IOException {
//        when(request.getParameter("name")).thenReturn("");
//        subjectServlet.doPost(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных данных");
//    }
//
//    @Test
//    public void testDoPostError() throws IOException, SQLException {
//        when(request.getParameter("name")).thenReturn("Math");
//        when(subjectService.saveNewSubject(any(SubjectDTO.class)).thenThrow(new SQLException("Database Error")));
//
//        subjectServlet.doPost(request, response);
//
//        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
//    }
//
//    @Test
//    public void testDoDeleteSuccess() throws IOException {
//        when(request.getParameter("name")).thenReturn("Math");
//        when(subjectService.deleteSubject(any(SubjectDTO.class))).thenReturn(true);
//
//        subjectServlet.doDelete(request, response);
//
//        verify(subjectService, times(1)).deleteSubject(any(SubjectDTO.class));
//        assertEquals(200, response.getStatus());
//    }
//
//    @Test
//    public void testDoDeleteBadRequest() throws IOException {
//        when(request.getParameter("name")).thenReturn("");
//        subjectServlet.doDelete(request, response);
//
//        verify(response, times(1)).sendError(400, "Проверьте корректность введенных данных");
//    }
//
//    @Test
//    public void testDoDeleteError() throws IOException, SQLException {
//        when(request.getParameter("name")).thenReturn("Math");
//        when(subjectService.deleteSubject(any(SubjectDTO.class)).thenThrow(new SQLException("Database Error")));
//
//        subjectServlet.doDelete(request, response);
//
//        verify(response, times(1)).sendError(400, "Ошибка работы базы данных");
//    }
//}
