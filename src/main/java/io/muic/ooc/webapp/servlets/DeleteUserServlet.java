package io.muic.ooc.webapp.servlets;

import com.mysql.cj.util.StringUtils;
import io.muic.ooc.webapp.security.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends AbstractRoutableHttpServlet{



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(securityService.isAuthorized(request)){
            String username = securityService.getCurrentUsername(request);
            request.setAttribute("username",username);
            try{
                User currentUser = userService.findByUsername(username);
                User deleteUser = userService.findByUsername(request.getParameter("username"));
                if(currentUser.getUsername().equals(deleteUser.getUsername())){
                    request.getSession().setAttribute("hasError", true);
                    request.getSession().setAttribute("message", "You are not allowed to delete your own account.");
                }
                else{
                    if(userService.deleteUser(deleteUser.getUsername())){
                        request.setAttribute("hasError",false);
                        request.getSession().setAttribute("message",String.format("Successfully deleted User %s.", deleteUser.getUsername()));
                    }
                    else{
                        request.setAttribute("hasError",true);
                        request.getSession().setAttribute("message",String.format("Unsuccessful deletion of User %s.", request.getParameter("username")));
                    }
                }

            }
            catch (Exception e){
                request.setAttribute("hasError",true);
                request.getSession().setAttribute("message",String.format("Unsuccessful deletion of User %s.", request.getParameter("username")));
            }
            response.sendRedirect("/");
        }
        else{
            response.sendRedirect("/login");
        }
    }

    @Override
    public String getPattern() {
        return "/user/delete";
    }
}
