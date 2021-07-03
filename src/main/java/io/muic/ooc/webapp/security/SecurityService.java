package io.muic.ooc.webapp.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SecurityService {

    private Database db;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isAuthorized(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = getCurrentUsername(request);
        return userService.checkIfUserExists(username);
    }
    public String getCurrentUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object usernameObject = session.getAttribute("username");
        return (String) usernameObject;
    }

    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
    }

    public boolean login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByUsername(username);
        if(user!=null && Objects.equals(user.getPassword(),password)){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return true;
        }
        else {
            return false;
        }


    }
}
