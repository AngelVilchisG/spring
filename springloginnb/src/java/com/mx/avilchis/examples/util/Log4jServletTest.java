/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.avilchis.examples.util;

import java.io.File;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * Clase para incializar el servlet de Log4j para logs de la aplicación
 *
 * @author avilchis
 * @date 2018-10-26.
 */
//Hereda los metodos de la clase HttpServlet
public class Log4jServletTest extends HttpServlet {

    //private static final Long SERIALVERSION = 1L;

    /**
     * M-etodo que inicializa el servlet de log4j para la captura de logs.
     * @author avilchis
     * @date 2018-10-26.
     * @param config configuración de contexto de servlet
     * @throws ServletException
     */
    @Override
    public void init( ServletConfig config ) throws ServletException {
        try {
            //Variable que guarda la ubicación del archivo de configuración del servlet.
            String lstLog4jLocation = config.getInitParameter( "log4jConfigLocation" );
            //Variable que obtiene la configuración de arranque del servlet
            ServletContext lobServletCtx = config.getServletContext();
            if ( lstLog4jLocation == null ) { //Valida si objeto es vacio.
                //Crea uno con la configuración de arranque.
                BasicConfigurator.configure();
            } else {//El objeto no es vacío.
                //Variable que obtiene la ruta absoluta de la aplicación.
                String lstAppPath = lobServletCtx.getRealPath("/");
                //Variable que guarda la ruta absoluta y la ubicación de archivo de configuración Log4j.
                String lstLog4jProps = lstAppPath + lstLog4jLocation;
                try {
                    //Variable que crea un archivo de configuración Log4j.
                    File lfiLog4jProps = new File( lstLog4jProps );
                    if ( lfiLog4jProps.exists() ) {//El archivo existe.
                        //Crea la configuración de arranque.
                        PropertyConfigurator.configure(lstLog4jProps);
                    } else {//El archivo no existe.
                        //Crea uno con la configuración de arranque.
                        BasicConfigurator.configure();
                    }
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
            //Refiere al metodo init (metodo padre), reemplazado en esta clase.
            super.init( config );
        } catch ( ServletException se ) {
            se.printStackTrace();
        }
    }//End Method

}//End Class
