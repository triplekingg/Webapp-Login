package io.muic.ooc.webapp.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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


    public static void main(String[] args) {
        try{
            Database db = new Database();
            Connection con = db.connect();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM User_List as u WHERE u.user_id = 'tpk'");
            if(rs.next()==false){
                System.out.println("false");
            }
            else{
                System.out.println("True");
            }
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(3)+"  "+rs.getString(4));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

