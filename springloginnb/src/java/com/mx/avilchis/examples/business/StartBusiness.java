/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.avilchis.examples.business;

import com.mx.avilchis.examples.dao.StartDAO;
import com.mx.avilchis.examples.model.LoginParams;
import static java.time.Instant.now;
import java.time.ZoneId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;


/**
 * Clase que contiene la lógica de negocio y operaciones para procesar las 
 * solicitudes que vienen de StartController.
 * @author avilchis
 * @date 2018-10-24.
 */
public class StartBusiness {
    //Variable que captura las salidas al log de la aplicación.
    private static final Logger LOGGER = Logger.getLogger( StartBusiness.class );
    //Variable global para acceder a los metodos del DAO.
    StartDAO gobStartDAO = new StartDAO();
    
    /**
     * Método que recibe parametros del Controller y realiza la lógica y operaciones 
     * para dar una respuesta.
     * @author avilchis
     * @date 2018-10-24.
     * @param modelo vista que va a dirigir
     * @param request guarda variables de sesión
     * @param response devuelve cookies
     * @param user parametro para utilizar
     * @param password parametro para utilizar
     * @return SUCCESS=user || ERROR=error
     */
    public ModelAndView getLogin( ModelAndView modelo, HttpServletRequest request, HttpServletResponse response, String user, String password ){
        //Variable local para obtener la información del modelo.
        LoginParams lobRespuesta;
        try{
            //Realiza llamada a método DAO para obtener la información del Login.
            lobRespuesta = gobStartDAO.getLogin();
            if( lobRespuesta != null )//Si el objeto no está vacio.
            {
                if( user.matches( "[A-Z]{4,10}" ) && password.matches( "[a-zA-Z0-9]{4,12}" ) )//Compara que el usuario y contraseña del Controller cumplan con el patrón asignado 
                {
                    if( lobRespuesta.getUserName().toUpperCase().compareTo(user)  == 0 && //Compara usuario de modelo contra usuario de Controller.
                        lobRespuesta.getPasswd().compareTo( password ) == 0 )//Compara contraseña de modelo contra contraseña de Controller.
                    {
                        LOGGER.info( "El usuario " + lobRespuesta.getUserName() +" ha inciado sesión, " + now().atZone(ZoneId.systemDefault()).toString() );                       
                        modelo = new ModelAndView("redirect: user.htm" );
                        return modelo;
                    }else{//El usuario y contraseña del modelo no coinciden con los del Controller.
                        LOGGER.info( "Usuario o Contraseña incorrectos" );
                        modelo = new ModelAndView( "login" );
                        modelo.addObject( "message", "Los datos ingresados no son correctos" );
                    }
                }else{
                    LOGGER.info( "Usuario o Contraseña incorrectos" );
                    modelo = new ModelAndView( "login" );
                    modelo.addObject( "message", "Los datos ingresados no son correctos" );
                }
            }else{//El objeto esta vacio
                LOGGER.info( "La respuesta no contiene elementos para terminar de procesar la solicitud." );
                modelo = new ModelAndView( "error" );
                modelo.addObject( "message", "Lo sentimos, ocurrió un error en el servidor" );
            }
        }catch( Exception e ){
            LOGGER.error( "ERROR: StartBusiness.getLogin()" + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message" + e.getMessage() );
        }
        return modelo;
    }//End Method
    
}//End Class
