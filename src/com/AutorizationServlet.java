package com;

import com.company.DAO;
import com.company.UsersDAO;
import com.company.Users_dataDAO;
import com.model.User;
import com.model.User_data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
       /* String login=req.getParameter("login");
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
        */
        SessionFactory factory=null;
        try {
            Configuration conf = new Configuration();
            factory = conf.configure().buildSessionFactory();

            DAO<User, String> userDAO = new UsersDAO(factory);
            DAO<User_data, String> user_dataDAO = new Users_dataDAO(factory);

            User user = new User();
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            user=userDAO.read(req.getParameter("login"));
            if(user.getLogin().equals("???")==true || user.getPassword().equals(req.getParameter("password"))!=true){
                req.setAttribute("errorUserNotFound","Wrong login or password");
                req.getRequestDispatcher("AutorizWindow.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("userName", user.getLogin());
                req.getRequestDispatcher("MainWindow.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
