package io.muic.ooc.webapp.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService{
    Database db = new Database();

    public User findByUsername(String username){
        String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+username+"'";
        try {
            ResultSet rs=db.getResultSet(sql);
            rs.next();
            return new User(rs.getString(1),rs.getString(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean checkIfUserExists(String username)throws SQLException{
        String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+username+"'";
        ResultSet rs=db.getResultSet(sql);
        return rs.next();
    }

    public List<String> returnUserList(List user_list) throws SQLException {
        String sql = "select * from User_List";
        ResultSet rs=db.getResultSet(sql);
        while (rs.next()){
            user_list.add(rs.getString(1));
        }
        return user_list;
    }

    public String displayUsers(){
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

//    public List<String> UserTable(){
//        try {
//            return  db.returnUserList(user);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }





}
