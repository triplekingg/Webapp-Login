package io.muic.ooc.webapp.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;

public class Database {


    public  ResultSet getResultSet(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/User_Details","hw4","Tripleking123");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            return rs;
        }
        catch(Exception e){ return null;}
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


//    public List<String> returnUserList(List user_list) throws SQLException {
//        String sql = "select * from User_List";
//        ResultSet rs=getResultSet(sql);
//        while (rs.next()){
//            user_list.add(rs.getString(1));
//        }
//        return user_list;
//    }

    public static void create_user(String username, String password){
        String sql = "INSERT INTO User_List(username, password)" + "VALUES ("+"\'"+username+"\'"+","+"\'"+password+"\'"+")";
        Connection con = connect();
        Statement smt= null;
        try {
            smt = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            smt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean addUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        User user = userService.findByUsername(username);
        if(user!=null && Objects.equals(user.getPassword(),password)){
            create_user(username,password);
            return true;
        }
        else {
            return false;
        }
    }


    //Function to display a list of users

//    public String tableToString(){
//        List<String> users = new ArrayList<>();
//        try {
//            users = returnUserList(users);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        StringBuilder s = new StringBuilder();
//
//        s.append(String.format("%-20s\n","Users"));
//        s.append(String.format("===================\n"));
//        for(String username : users) {
//            s.append(String.format("%-20s",username));
//        }
//        return s.toString();
//    }


//    public static void main(String[] args) {
//        try{
//            System.out.println(tableToString());
//        }catch(Exception e){ System.out.println(e);}
//    }
}

