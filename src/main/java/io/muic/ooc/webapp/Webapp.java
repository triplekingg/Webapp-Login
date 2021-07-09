package io.muic.ooc.webapp;

import java.io.File;
import java.sql.Connection;
import javax.servlet.ServletException;

import io.muic.ooc.webapp.security.Database;
import io.muic.ooc.webapp.servlets.ServletRouter;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Webapp {

    public static void main(String[] args) {

        File docBase = new File("src/main/webapp/");
        docBase.mkdirs();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);


        try {
            Context ctx = tomcat.addWebapp("", docBase.getAbsolutePath());
            ServletRouter servletRouter = new ServletRouter();
            servletRouter.init(ctx);
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }

    }
}
