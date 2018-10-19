/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.springloginmvn.business;

import com.mx.springloginmvn.dao.LoginDAO;
import com.mx.springloginmvn.model.LoginVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author avilchis
 */
public class LoginBusiness {
    private static final Logger LOGGER = Logger.getLogger( LoginBusiness.class );
    
    LoginDAO gobLoginDAO = new LoginDAO();

    public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response, String user, String passwd) {
        System.out.println("getLogin() Business");
        ModelAndView modelo;
        LoginVO lobRespuesta;
        
        try{
            lobRespuesta = gobLoginDAO.getLogin( user, passwd );
            if( lobRespuesta != null || !lobRespuesta.toString().isEmpty() ){
                if( lobRespuesta.getUser() == user && lobRespuesta.getPassword() == passwd ){
                    LOGGER.info( "El usuario: "+  lobRespuesta.getUser() +", ha iniciado sesión." );
                    modelo = new ModelAndView( "user" );
                    modelo.addObject( "user", lobRespuesta.getUser() );
                    return modelo;
                }else{
                    LOGGER.info( "Los datos ingresados son incorrectos" );
                    modelo = new ModelAndView( "login" );
                    modelo.addObject( "message", "Los datos no son correctos" );
                }
            }else{
                LOGGER.info( "No se encontró la información para completar la solicitud" );
                modelo = new ModelAndView( "error" );
                modelo.addObject( "message", "Ocurrio un error en el servidor" );
            }
        }catch( Exception e ){
            LOGGER.error("ERROR: " + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message", e.getMessage() );
        }
        System.out.println("modelo: " + modelo);
        return modelo;
        
    }
    
}
