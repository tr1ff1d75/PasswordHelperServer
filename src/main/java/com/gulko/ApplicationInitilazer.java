package com.gulko;

import com.gulko.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitilazer implements WebApplicationInitializer {
    private final static String DISPATCHER = "dispatcher";
    private final static String DISPATCHER_2 = "dispatcher_2";
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        MessageDispatcherServlet servletSoap = new MessageDispatcherServlet();
        servletSoap.setApplicationContext(ctx);
        servletSoap.setTransformWsdlLocations(true);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(DISPATCHER_2, servletSoap);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        dynamic.addMapping("/soapws/*");
        dynamic.setLoadOnStartup(2);

    }
}
