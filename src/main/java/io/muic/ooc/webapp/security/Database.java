package io.muic.ooc.webapp.security;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {


    public Connection connect(){
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

    public List<String> returnUserList(List user_list) throws SQLException {
        String sql = "select * from User_List";
        Connection con = connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()){
            user_list.add(rs.getString(1));
        }
        return user_list;
    }


//    public static void main(String[] args) {
//        try{
//            String u = "t";
//            String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+u+"'";
//            Connection con = connect();
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery(sql);
//            if(rs.next()==false){
//                System.out.println("false");
//            }
//            else{
//                System.out.println("True");
//            }
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(3)+"  "+rs.getString(4));
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//    }
}

