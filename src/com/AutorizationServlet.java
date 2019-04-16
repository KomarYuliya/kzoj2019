package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AutorizWindow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        DataBase db=new DataBase();
        String[] buf = db.find("SELECT username FROM users WHERE login='"+login+"' AND password='"+password+"'","username");
        if(buf[0]!=null) {
            req.setAttribute("userName",buf[0]);
            req.getRequestDispatcher("MainWindow.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("errorUserNotFound","Wrong login or password");
            req.getRequestDispatcher("AutorizWindow.jsp").forward(req,resp);
        }
    }
}
