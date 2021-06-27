package io.muic.ooc.webapp;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable{

    @Override
    public String getPattern() {
        return null;
    }
}
