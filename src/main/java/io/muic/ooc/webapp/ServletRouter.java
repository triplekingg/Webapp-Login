package io.muic.ooc.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class ServletRouter {

    public void init(Context ctx){
        LoginServlet loginServlet = new LoginServlet();
        Tomcat.addServlet(ctx, LoginServlet.class.getSimpleName(), loginServlet);
        ctx.addServletMapping("/login", LoginServlet.class.getSimpleName());

        HomeServlet homeServlet = new HomeServlet();
        Tomcat.addServlet(ctx, "HomeServlet", homeServlet);
        // TRICK: mapping with index.jsp, allow access to root path "/"
        ctx.addServletMapping("/index.jsp", "HomeServlet");

        LogoutServlet logoutServlet = new LogoutServlet();
        Tomcat.addServlet(ctx, LogoutServlet.class.getSimpleName(), logoutServlet);
        ctx.addServletMapping("/logout", LogoutServlet.class.getSimpleName());
    }
}
