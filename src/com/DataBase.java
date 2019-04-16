package com;

import java.sql.*;

public class DataBase {
    Connection co;
    public DataBase(){
        try{
            String dir="D:\\Универ\\Курсач6сем\\untitled2";
            Class.forName("org.sqlite.JDBC");
            co= DriverManager.getConnection("JDBC:sqlite:"+dir+"\\database.db");
            System.out.println("Соединение установлено!\n-----------------\n");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String[] find(String query, String column){
        String[] buf=new String[100];
        try{
            Statement statement=co.createStatement();
            ResultSet rs=statement.executeQuery(query);
            int i=0;
            while(rs.next()){
                buf[i]=rs.getString(column);
                i++;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return buf;
    }
    public int registartion(String[] data){
        int isSuccess=0;
        try{
            String query="INSERT INTO users VALUES (NULL";
            for(int i=0;i<3;i++){
                query+=",'"+data[i]+"'";
            }
            query+=", 1)";
            Statement statement=co.createStatement();
            statement.executeUpdate(query);
            query="INSERT INTO users_data VALUES(NULL";
            for(int i=2;i<data.length-1;i++){
                query+=",'"+data[i]+"'";
            }
            query+=","+Integer.toString(Integer.parseInt(data[5])+Integer.parseInt(data[6]));
            query+=","+Integer.toString(Integer.parseInt(data[5])-Integer.parseInt(data[6]));
            query+=")";
            statement.executeUpdate(query);
            isSuccess=1;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            isSuccess=0;
        }

        return isSuccess;
    }
    public int add(String tableName, String[] data){
        int isSuccess;
        try{
            String query="INSERT INTO "+tableName+" VALUES (NULL";
            for(int i=0;i<data.length;i++){
                query+=",'"+data[i]+"'";
            }
            query+=")";
            Statement statement=co.createStatement();
            statement.executeUpdate(query);
            isSuccess=1;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            isSuccess=0;
        }
        return isSuccess;
    }
}
