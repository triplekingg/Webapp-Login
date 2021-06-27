package io.muic.ooc.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ServletRouter {

    private static final List<Class<? extends AbstractRoutableHttpServlet>> servletClasses = new ArrayList<>();
    static {
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(LogoutServlet.class);
    }

    public void init(Context ctx){
        for(Class<? extends AbstractRoutableHttpServlet> servletClass:servletClasses){
            try {
                AbstractRoutableHttpServlet httpServlet = servletClass.getDeclaredConstructor().newInstance();
                Tomcat.addServlet(ctx, servletClass.getSimpleName(), httpServlet);
                ctx.addServletMapping(httpServlet.getPattern(), servletClass.getSimpleName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
