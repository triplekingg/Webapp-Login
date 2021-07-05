package io.muic.ooc.webapp.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author gigadot
 */
public class AddUserServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(securityService.isAuthorized(request)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add_user.jsp");
            requestDispatcher.include(request,response);
        }
        else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        //check if user is a valid user
        if(userService.create_user(request)){
            response.sendRedirect("/");
        }
        else{
             error = "Username already exists";
             request.setAttribute("error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add_user.jsp");
            requestDispatcher.include(request,response);
        }
    }

    @Override
    public String getPattern() {
        return "/add_user";
    }
}
