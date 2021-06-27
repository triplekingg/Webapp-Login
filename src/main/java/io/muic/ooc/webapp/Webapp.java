package io.muic.ooc.webapp;

import java.io.File;
import javax.servlet.ServletException;

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
        } catch (ServletException | LifecycleException ex) {
            ex.printStackTrace();
        }

    }
}
