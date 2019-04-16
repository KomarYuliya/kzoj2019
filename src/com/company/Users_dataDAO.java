package com.company;

import com.model.User_data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Users_dataDAO implements DAO<User_data, String> {
    private SessionFactory factory;
    public Users_dataDAO(SessionFactory factory){
        this.factory=factory;
    }
    public boolean create(User_data user_data){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.save(user_data);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return result;
    }

    public User_data read(String login) {
        User_data result=new User_data();
        result.setId(-1);
       /* try(PreparedStatement statement=connection.prepareStatement("fdfg")){
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                result.setId(rs.getInt("id"));
                result.setLogin(rs.getString("login"));
                result.setPassword(rs.getString("password"));
                result.setAccessLevel(rs.getInt("accessLevel"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }*/
        return result;
    }
    public boolean update(User_data user_data){
        boolean result=false;
      /*  try(PreparedStatement statement=connection.prepareStatement(" ")){
            result=true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }*/
        return result;
    }
    public boolean delete(User_data user_data){
        boolean result=false;
        return result;
    }
}
