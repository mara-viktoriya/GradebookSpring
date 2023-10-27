package org.example.servlet.subject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.example.db.ConnectionManager;
import org.example.db.DataBaseConnect;
import org.example.db.HikariCPDataSource;
import org.example.model.entity.SubjectEntity;
import org.example.repository.impl.SubjectRepositoryImpl;
import org.example.repository.interfaces.SubjectRepository;
import org.example.service.impl.SubjectServiceImpl;
import org.example.service.interfaces.SubjectService;
import org.example.servlet.dto.StudentDTO;
import org.example.servlet.dto.SubjectDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "SubjectServlet", value = "/subject")

public class SubjectServlet extends HttpServlet {

    private final ConnectionManager connectionManager;
    private final SubjectRepository<SubjectEntity, UUID> repository;
    private final SubjectService<SubjectEntity, UUID> service;

    public SubjectServlet() {
        this.connectionManager = new HikariCPDataSource();
        //this.connectionManager = new DataBaseConnect();
        this.repository = new SubjectRepositoryImpl(this.connectionManager);
        this.service = new SubjectServiceImpl(repository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (StringUtils.isBlank(name)){
            resp.sendError(400, "Проверьте корректность введенных данных");
        }
        else {
            try {
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setName(name);
                boolean added = service.saveNewSubject(subjectDTO);
                if (added){
                    resp.setStatus(200);
                }
                else {
                    resp.sendError(400, "Ошибка работы базы данных");
                }
            }

            catch (SQLException e){
                resp.sendError(400, "Ошибка работы базы данных");
            }

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (StringUtils.isBlank(name)){
            resp.sendError(400, "Проверьте корректность введенных данных");
        } else {
            try {
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setName(name);
                boolean deleted = service.deleteSubject(subjectDTO);
                if (deleted) {
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
