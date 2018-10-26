/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.avilchis.examples.util;

import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author avilchis
 */
@WebListener("application context listener")
public class ContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BasicConfigurator.configure();
        ServletContext context = sce.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4jConfigLocation");
        String fullPath = context.getRealPath("")+File.pathSeparator +log4jConfigFile;
        PropertyConfigurator.configure(fullPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
