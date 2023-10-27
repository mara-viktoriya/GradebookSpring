package org.example.servlet.student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.example.db.ConnectionManager;
import org.example.db.HikariCPDataSource;
import org.example.model.entity.StudentEntity;
import org.example.repository.impl.StudentRepositoryImpl;
import org.example.repository.interfaces.StudentRepository;
import org.example.service.impl.StudentServiceImpl;
import org.example.service.interfaces.StudentService;
import org.example.servlet.dto.MarkDTO;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    private final ConnectionManager connectionManager;
    private final StudentRepository<StudentEntity, UUID> repository;
    private final StudentService<StudentEntity, UUID> service;

    public StudentServlet() {
        this.connectionManager = new HikariCPDataSource();
        this.repository = new StudentRepositoryImpl(this.connectionManager);
        this.service = new StudentServiceImpl(repository);
    }


    // по имени студента получить все оценки по предмету
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String subject = req.getParameter("subject");
        if (StringUtils.isAnyBlank(surname, subject)) {
            resp.sendError(400, "Проверьте корректность введенных данных");
        } else {
            try {
                StudentDTO studentDtoOutgoing = new StudentDTO();
                studentDtoOutgoing.setSurname(surname);
                SubjectDTO subjectDtoOutgoing = new SubjectDTO();
                subjectDtoOutgoing.setName(subject);
                StudentDTO studentDtoIncoming = service.getMarksBySubject(studentDtoOutgoing, subjectDtoOutgoing);
                List<MarkDTO> markDTOList = studentDtoIncoming.getMarkDtoList();
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("Оценки по предмету "+subject);
                for (MarkDTO mark : markDTOList) {
                    out.println(mark.getValue());
                }
                resp.setStatus(200);

            } catch (SQLException e) {
                resp.sendError(400, "Ошибка работы базы данных");
            } catch (RuntimeException e) {
                resp.sendError(400, e.getMessage());
            }

        }
    }

    //добавить нового студента
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        if (StringUtils.isBlank(surname)) {
            resp.sendError(400, "Проверьте корректность введенных данных");
        } else {
            try {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setSurname(surname);
                boolean added = service.saveNewStudent(studentDTO);
                if (added) {
                    resp.setStatus(200);
                } else {
                    resp.sendError(400, "Проверьте корректность введенных данных");
                }
            } catch (SQLException e) {
                resp.sendError(400, "Ошибка работы базы данных");
            } catch (RuntimeException e) {
                resp.sendError(400, e.getMessage());
            }

        }

    }

    //!РЕАЛИЗОВАТЬ
    // поменять имя студента
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldSurname = req.getParameter("old_surname");
        String newSurname = req.getParameter("new_surname");
        if (StringUtils.isAnyBlank(oldSurname, newSurname)) {
            resp.sendError(400, "Проверьте корректность введенных данных");
        } else {
            try {
                StudentDTO oldStudentDTO = new StudentDTO();
                oldStudentDTO.setSurname(oldSurname);
                StudentDTO newStudentDTO = new StudentDTO();
                oldStudentDTO.setSurname(newSurname);
                boolean added = service.changeStudent(oldStudentDTO, newStudentDTO);
                if (added) {
                    resp.setStatus(200);
                } else {
                    resp.sendError(400, "Проверьте корректность введенных данных");
                }
            } catch (SQLException e) {
                resp.sendError(400, "Ошибка работы базы данных");
            } catch (RuntimeException e) {
                resp.sendError(400, e.getMessage());
            }

        }
    }

        @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        if (StringUtils.isBlank(surname)) {
            resp.sendError(400, "Проверьте корректность введенных данных");
        } else {
            try {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setSurname(surname);
                boolean added = service.deleteStudent(studentDTO);
                if (added) {
                    resp.setStatus(200);
                } else {
                    resp.sendError(400, "Проверьте корректность введенных данных");
                }
            } catch (SQLException e) {
                resp.sendError(400, "Ошибка работы базы данных");
            } catch (RuntimeException e) {
                resp.sendError(400, e.getMessage());
            }
        }
    }


}
