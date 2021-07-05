package io.muic.ooc.webapp.servlets;

import io.muic.ooc.webapp.security.Database;
import io.muic.ooc.webapp.security.SecurityService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable{

    protected SecurityService securityService;
    protected Database database;

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
    public void setDatabase(Database database) {
        this.database = database;
    }
}
