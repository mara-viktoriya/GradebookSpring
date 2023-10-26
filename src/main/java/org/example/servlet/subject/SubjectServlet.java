package org.example.servlet.subject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SubjectServlet", value = "/subject")

public class SubjectServlet extends HttpServlet {
    // по имени предмета получить все оценки
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }
    }

    //добавить новый предмет
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }

    }
    // удалить предмет

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }

    }
}
