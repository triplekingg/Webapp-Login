package io.muic.ooc.webapp.servlets;

import io.muic.ooc.webapp.security.Database;
import io.muic.ooc.webapp.security.SecurityService;
import io.muic.ooc.webapp.security.UserService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable{

    protected SecurityService securityService;
    protected UserService userService;

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
