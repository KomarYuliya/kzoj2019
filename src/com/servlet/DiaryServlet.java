package com.servlet;

import com.SingleTone;
import com.company.*;
import com.model.Diary;
import com.model.Food;
import com.model.Statistic;
import com.model.User_data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/diary")
public class DiaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Configuration conf = new Configuration();
        SessionFactory factory = conf.configure().buildSessionFactory();
        DAO<User_data, String> users_dataDAO=new Users_dataDAO(factory);
        DAO<Statistic, String> statisticDAO=new StatisticDAO(factory);
        SingleTone singleTone=SingleTone.getInstance("login");
        User_data user_data=users_dataDAO.read(singleTone.getLogin());
        req.setAttribute("norms", "\n" +
                "            <td>Калории: "+user_data.getNormCal()+"</td>\n" +
                "            <td>Жиры: "+user_data.getNormFats()+"</td>\n" +
                "            <td>Белки: "+user_data.getNormProteins()+"</td>\n" +
                "            <td>Углеводы: "+user_data.getNormCarbohydrates()+"</td>");
        req.setAttribute("data", statisticDAO.getTableView(singleTone.getLogin()));
        req.getRequestDispatcher("DiaryWindow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Configuration conf = new Configuration();
        SessionFactory factory = conf.configure().buildSessionFactory();
        Diary diary=new Diary();
        DAO<Diary, String> diaryDAO=new DiaryDAO(factory);
        DAO<Food, String> foodDAO=new FoodDAO(factory);
        DAO<Statistic, String> statisticDAO=new StatisticDAO(factory);
        if(!req.getParameter("dish").equals("")){
            Food food=foodDAO.read(req.getParameter("dish"));
            if(food.getFoodName().equals("???")){
                req.setAttribute("errorNoSuchDish","Блюдо не найдено");
            }
            else {
                SingleTone singleTone=SingleTone.getInstance("login");
                diary.setLogin(singleTone.getLogin());
                diary.setDate(req.getParameter("date"));
                diary.setSize(Integer.parseInt(req.getParameter("size")));
                diary.setFoodName(req.getParameter("dish"));
                diaryDAO.create(diary);
                Statistic statistic=statisticDAO.read(singleTone.getLogin()+"+"+req.getParameter("date"));
                if(statistic.getLogin().equals("???")){
                    statistic.setLogin(singleTone.getLogin());
                    statistic.setDate(req.getParameter("date"));
                    statistic.setCurrCal(food.getCalories());
                    statistic.setCurrCarbohydrates(food.getCarbohydrates());
                    statistic.setCurrFats(food.getFats());
                    statistic.setCurrProteins(food.getProtein());
                    statisticDAO.create(statistic);
                }
            }
        }
        doGet(req, resp);
    }
}
