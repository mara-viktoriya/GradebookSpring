package org.example.servlet.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    // по имени студента получить все оценки по всем предметам
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    if (name == null){
        resp.sendError(400, "Введите значение");
    }
    }

    //добавить нового студента
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }


    }



    // поменять имя студента
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }
    }

    // удалить студента и все его оценки
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null){
            resp.sendError(400, "Неправильное значение");
        }
    }


}
