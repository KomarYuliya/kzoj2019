package com.company;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UsersDAO implements DAO<User, String> {
    private SessionFactory factory;
    public UsersDAO(SessionFactory factory){
        this.factory=factory;
    }
    public boolean create(User user){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return result;
    }

    public User read(String username) {
        User result=new User();
        result.setId(-1);

        try(Session session=factory.openSession()){
            result=session.get(User.class, username);
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result != null ? result : new User();
        }
    }
    public boolean update(User user){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            result = true;
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result;
        }
    }
    public boolean delete(User user){
        boolean result=false;
        try(Session session=factory.openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            result = true;
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally {
            return result;
        }
    }
}
