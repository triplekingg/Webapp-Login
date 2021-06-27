package io.muic.ooc.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author gigadot
 */
public class LogoutServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        securityService.logout(request);
        response.sendRedirect("/");
    }

    @Override
    public String getPattern() {
        return "/logout";
    }
}
