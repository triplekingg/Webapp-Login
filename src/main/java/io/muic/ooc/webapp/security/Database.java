package io.muic.ooc.webapp.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;

public class Database {


    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/User_Details","hw4","Tripleking123");
            return con;
        }
        catch(Exception e){ return null;}
    }

    public boolean ifExists(String user) throws SQLException {
        String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+user+"'";
        Connection con = connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        return rs.next();
    }




//    public Map<String,User> returnHashmap(Map<String,User> users) throws SQLException {
//        String sql = "select * from User_List";
//        Connection con = connect();
//        Statement stmt=con.createStatement();
//        ResultSet rs=stmt.executeQuery(sql);
//        while(rs.next()){
//            users.put(rs.getString(1), new User(rs.getString(1),rs.getString(2)));
//        }
//        return  users;
//    }


    public static List<String> returnUserList(List user_list) throws SQLException {
        String sql = "select * from User_List";
        Connection con = connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()){
            user_list.add(rs.getString(1));
        }
        return user_list;
    }

    public static void create_user(String username, String password, Statement smt){
        String sql = "INSERT INTO User_List(username, password)" + "VALUES ("+"\'"+username+"\'"+","+"\'"+password+"\'"+")";
        try {
            smt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //Function to display a list of users

    public static String tableToString(){
        List<String> users = new ArrayList<>();
        try {
            users = returnUserList(users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        StringBuilder s = new StringBuilder();

        s.append(String.format("%-20s\n","Users"));
        s.append(String.format("===================\n"));
        for(String username : users) {
            s.append(String.format("%-20s",username));
        }
        return s.toString();
    }


//    public static void main(String[] args) {
//        try{
//            System.out.println(tableToString());
//        }catch(Exception e){ System.out.println(e);}
//    }
}

