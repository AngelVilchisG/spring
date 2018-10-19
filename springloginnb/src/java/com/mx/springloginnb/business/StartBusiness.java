/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.springloginnb.business;

import com.mx.springloginnb.dao.StartDAO;
import com.mx.springloginnb.model.LoginParams;
import static java.time.Instant.now;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author avilchis
 */
public class StartBusiness {
    private static final Logger LOGGER = Logger.getLogger( StartBusiness.class );
    
    StartDAO objDAO = new StartDAO();
    
    public ModelAndView getLogin( HttpServletRequest request, HttpServletResponse response, String user, String password ){
        ModelAndView  modelo;
        LoginParams respuesta;
        try{
            respuesta = objDAO.getLogin2( user, password );
            if( respuesta != null || !respuesta.toString().isEmpty() ){
                if( respuesta.getUserName() == user && respuesta.getPasswd() == password ){
                    LOGGER.info("El usuario " + respuesta.getUserName() +" ha inciado sesión, " + now().toString() );
                    modelo = new ModelAndView( "user" );
                    modelo.addObject( "message", respuesta.getUserName() );
                    return modelo;
                }else{
                    LOGGER.error("ERROR: Usuario o Contraseña incorrectos" );
                    modelo = new ModelAndView( "login" );
                    modelo.addObject( "message", "Los datos ingresados no son correctos" );
                }
            }else{
                LOGGER.error("ERROR: La respuesta no contiene elementos para terminar de procesar la solicitud." );
                modelo = new ModelAndView( "error" );
                modelo.addObject( "message", "Lo sentimos, ocurrió un error en el servidor" );
                return modelo;
            }
        }catch( Exception e ){
            LOGGER.error("ERROR: " + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message" + e.getMessage() );
        }
        return modelo;
    }
    
    
}
