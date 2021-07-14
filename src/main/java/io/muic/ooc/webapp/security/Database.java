package io.muic.ooc.webapp.security;
import io.muic.ooc.webapp.config.ConfigProperties;
import io.muic.ooc.webapp.config.ConfigurationLoader;

import java.sql.*;

public class Database {
    Connection con;

    public Database(){
        ConfigProperties configProperties = ConfigurationLoader.load();
        try {
            con = DriverManager.getConnection(
                    configProperties.getDatabaseConnectionUrl(), configProperties.getDatabaseUsername(), configProperties.getDatabasePassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ResultSet getResultSet(String sql) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    public Statement getStatement(String sql) {
        try {
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            return null;
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            return stmt;
        } catch (Exception e) {
            return null;
        }
    }

}

