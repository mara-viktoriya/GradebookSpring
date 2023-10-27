package org.example.servlet.mark;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.example.db.ConnectionManager;
import org.example.db.DataBaseConnect;
import org.example.db.HikariCPDataSource;
import org.example.model.entity.MarkEntity;
import org.example.repository.impl.MarkRepositoryImpl;
import org.example.repository.interfaces.MarkRepository;
import org.example.service.impl.MarkServiceImpl;
import org.example.service.interfaces.MarkService;
import org.example.servlet.dto.AddMarkDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "MarkServlet", value = "/mark")
public class MarkServlet extends HttpServlet {

    private final ConnectionManager connectionManager;
    private final MarkRepository<MarkEntity, UUID> repository;
    private final MarkService<MarkEntity, UUID> service;

    public MarkServlet() {
        this.connectionManager = new HikariCPDataSource();
        //this.connectionManager = new DataBaseConnect();
        this.repository = new MarkRepositoryImpl(this.connectionManager);
        this.service = new MarkServiceImpl(this.repository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mark = req.getParameter("mark");
        String surname = req.getParameter("surname");
        String subject = req.getParameter("subject");
        if (StringUtils.isAnyBlank(mark,surname,subject)){
            resp.sendError(400, "Проверьте корректность введенных данных");
        }
        else {
            try {
                AddMarkDTO addMarkDTO = new AddMarkDTO(Integer.parseInt(mark), surname, subject);
                boolean added = service.addMark(addMarkDTO);
                if (added){
                    resp.setStatus(200);
                }
                else {
                    resp.sendError(400, "Проверьте корректность введенных данных");
                }
            }

            catch (SQLException e){
                resp.sendError(400, "Ошибка работы базы данных");
            }

        }



//        Optional.ofNullable(req.getParameter("mark"))
//                .ifPresentOrElse(MarkServlet::doSmth, () -> sendError(resp));\
    }

//    private static void doSmth(String it) {
//        System.out.println(it);
//            }
//    private static void sendError(HttpServletResponse resp) {
//        try {
//            resp.sendError(400);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
