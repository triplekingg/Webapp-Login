package io.muic.ooc.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class ServletRouter {

    private static final List<Class<? extends HttpServlet>> servletClasses = new ArrayList<>();
    static {
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(LogoutServlet.class);
    }

    public void init(Context ctx){
        for(Class<? extends HttpServlet> servletClass:servletClasses){
            try {
                HttpServlet httpServlet = servletClass.newInstance();
                Tomcat.addServlet(ctx, LoginServlet.class.getSimpleName(), httpServlet);
                ctx.addServletMapping("/index.jsp", LoginServlet.class.getSimpleName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }



        HomeServlet homeServlet = new HomeServlet();
        Tomcat.addServlet(ctx, "HomeServlet", homeServlet);
        // TRICK: mapping with index.jsp, allow access to root path "/"
        ctx.addServletMapping("/index.jsp", "HomeServlet");

        LogoutServlet logoutServlet = new LogoutServlet();
        Tomcat.addServlet(ctx, LogoutServlet.class.getSimpleName(), logoutServlet);
        ctx.addServletMapping("/logout", LogoutServlet.class.getSimpleName());
    }
}
