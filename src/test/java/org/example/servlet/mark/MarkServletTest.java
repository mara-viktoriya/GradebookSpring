//package org.example.servlet.mark;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.db.ConnectionManager;
//import org.example.model.entity.MarkEntity;
//import org.example.repository.interfaces.MarkRepository;
//import org.example.service.interfaces.MarkService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.UUID;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class MarkServletTest {
//
//    @Mock
//    private ConnectionManager connectionManager;
//
//    @Mock
//    private MarkRepository<MarkEntity, UUID> markRepository;
//
//    @Mock
//    private MarkService<MarkEntity, UUID> markService;
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
//    private MarkServlet markServlet;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        markServlet = new MarkServlet(connectionManager, markRepository, markService);
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
//        markServlet.doPost(request, response);
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
//        markServlet.doPost(request, response);
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
//        when(markService.addMark(any(AddMarkDTO.class)).thenThrow(new SQLException()));
//
//        markServlet.doPost(request, response);
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
//}