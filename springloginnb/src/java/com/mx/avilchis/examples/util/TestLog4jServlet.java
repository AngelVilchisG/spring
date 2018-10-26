/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.avilchis.examples.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author avilchis
 */
@WebServlet("/test")
public class TestLog4jServlet extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Inicio de Log4j");
        try{
            String html = "<html><h1>Log4j ha inciado logger con exito</h1></html>";
            resp.getWriter().println(html);
        }catch( Exception e ){
            LOGGER.error("ERROR: TestLog4jServlet.doTest(), LOGGER no inicio correctamente." + e, e);
        }
    }
    
    
}
