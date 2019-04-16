package com;

import com.company.DAO;
import com.company.UsersDAO;
import com.company.Users_dataDAO;
import com.model.User;
import com.model.User_data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args){
        SessionFactory factory=null;
        try{
      /*      Configuration obj=new Configuration();
            factory=obj.configure().buildSessionFactory();
            DAO<User, String> userDAO=new UsersDAO(factory);
            DAO<User_data, String> user_dataDAO=new Users_dataDAO(factory);
            User user=new User();
            User_data user_data=new User_data();
            user.setLogin("logiiiiiin");
            user.setPassword("password");
            user.setUsername("username122232");
            user.setAccessLevel(1);
            user_data.setUsername("username122232");
            user_data.setAge(22);
            user_data.setMail("co.a@ua.ru");
            user_data.setHeight(123);
            user_data.setWeight(23.4);
            user_data.setNormGBU(11);
            user_data.setNormKK(23);
            userDAO.create(user);
           // System.out.println(userDAO.read("username1").getLogin());
            user_dataDAO.create(user_data);*/
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.exit(0);
        }
    }
}
