package io.muic.ooc.webapp.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService extends Database{
    List<String> user = new ArrayList<>();

    public static User findByUsername(String username){
        String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+username+"'";
        Connection con = connect();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            return new User(rs.getString(1),rs.getString(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean checkIfUserExists(String username){
        try {
            return ifExists(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<String> UserTable(){
        try {
            return  returnUserList(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }





}
