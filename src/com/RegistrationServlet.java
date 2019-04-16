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
import java.util.Enumeration;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("RegWindow.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration en=req.getParameterNames();
        String[] buf=new String[8];
        int i=0;
      /*  while (en.hasMoreElements()){
            buf[i]=req.getParameter((String)en.nextElement());
            System.out.println(buf[i]);
            i++;
        }*/
     //   System.out.println(req.getParameter("login"));
        registration(req);

        req.getRequestDispatcher("RegWindow.jsp").forward(req,resp);
    }
    private void registration(HttpServletRequest req){
        SessionFactory factory=null;
        try{
            Configuration conf=new Configuration();
            factory=conf.configure().buildSessionFactory();

            DAO<User, String> userDAO=new UsersDAO(factory);
            DAO<User_data, String> user_dataDAO=new Users_dataDAO(factory);

            User user=new User();
            user.setId(1);
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            user.setUsername(req.getParameter("username"));
            user.setAccessLevel(0);
            userDAO.create(user);

            User_data user_data=new User_data();
            user_data.setUsername(req.getParameter("username"));
            user_data.setId(1);
            user_data.setAge(Integer.parseInt(req.getParameter("age")));
            user_data.setHeight(Integer.parseInt(req.getParameter("height")));
            user_data.setWeight(Integer.parseInt(req.getParameter("weight")));
            user_data.setNormKK(12);
            user_data.setNormGBU(12);
            user_data.setMail(req.getParameter("email"));
            user_dataDAO.create(user_data);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
       //     System.exit(0);
        }
    }
}
