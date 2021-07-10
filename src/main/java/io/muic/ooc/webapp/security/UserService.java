package io.muic.ooc.webapp.security;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService{
    private Database db = new Database();
    private SecurityService securityService = new SecurityService();

    public User findByUsername(String username){
        String sql = "SELECT * FROM User_List as u WHERE u.user_id ='"+username+"'";
        try {
            ResultSet rs=db.getResultSet(sql);
            rs.next();
            return new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));
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

    public List<User> returnUserList(List user_list) throws SQLException {
        String sql = "select * from User_List";
        ResultSet rs=db.getResultSet(sql);
        while (rs.next()){
            user_list.add(new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        return user_list;
    }

    public List<User> displayUsers(){
        List<User> users = new ArrayList<>();
        try {
            users = returnUserList(users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(String username){
        String sql = "DELETE FROM User_List as u WHERE u.user_id = ?";
        PreparedStatement stmt = db.getPreparedStatement(sql);
        try {
            stmt.setString(1,username);
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

//    public String displayUsers(){
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

    public boolean create_user(HttpServletRequest request){
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password");
        String displayName = request.getParameter("displayName").trim();
        String confirmPassword = request.getParameter("confirmPassword");
        String error="";
        String confirmation ="";
        try {
            if(checkIfUserExists(username)){
                error = "Username already exists";
                request.setAttribute("error", error);
                return false;
            }

            if(!password.equals(confirmPassword)){
                confirmation = "Passwords don't match";
                request.setAttribute("confirmation",confirmation);
                return false;
            }
            else{
                String sql = "INSERT INTO User_List(user_id, password, display_name)" + "VALUES ("+"\'"+username+"\'"+","+"\'"+password+"\'"+","+"\'"+displayName+"\'"+")";
                Statement stmt = db.getStatement(sql);
                stmt.executeUpdate(sql);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
