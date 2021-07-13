package io.muic.ooc.webapp.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;

public class Database {


    public ResultSet getResultSet(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/User_Details", "hw4", "Tripleking123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    public Statement getStatement(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/User_Details", "hw4", "Tripleking123");
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            return null;
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/User_Details", "hw4", "Tripleking123");
            PreparedStatement stmt = con.prepareStatement(sql);
            return stmt;
        } catch (Exception e) {
            return null;
        }
    }


    public void create_user(String username, String password, Statement smt) {
        String sql = "INSERT INTO User_List(username, password)" + "VALUES (" + "\'" + username + "\'" + "," + "\'" + password + "\'" + ")";
        try {
            smt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

