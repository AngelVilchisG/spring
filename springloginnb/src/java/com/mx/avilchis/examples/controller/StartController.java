/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.avilchis.examples.controller;

import com.mx.avilchis.examples.business.StartBusiness;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Clase que mapea las vistas de la aplicación.
 * @author avilchis
 * @date 2018-10-24.
 */
@Controller
public class StartController {
    //Variable para capturar las salidas del log de la aplicación.
    private static final Logger LOGGER = Logger.getLogger( StartController.class );
    //Variable global para llamar a los metodos de StartBusiness.
    StartBusiness gobStartBusiness = new StartBusiness();
    
    /**
     * Método que muestra la página de index.htm.
     * @author avilchis
     * @date 2018-10-24.
     * @param request
     * @param response
     * @return modelo
     */
    @RequestMapping( value = {"/index"}, method = {RequestMethod.GET} )
    public ModelAndView start( HttpServletRequest request, HttpServletResponse response ){
        //Definción para la variable del modelo.
        ModelAndView modelo;
        try{
            //Creación del objeto modelo y asignación de la vista index.
            modelo = new ModelAndView( "index" );
        }catch( Exception e ){
            LOGGER.error("ERROR: " + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject("ERROR: " + e.getMessage() );
        }
        return modelo;
    }//End Method
    
    /**
     * Método que muestra la página de login.htm.
     * @author avilchis
     * @date 2018-10-24.
     * @param request
     * @param response
     * @return modelo
     */
    @RequestMapping( value = {"/login"},  method = {RequestMethod.GET} )
    public ModelAndView login( HttpServletRequest request, HttpServletResponse response ){
        //Definción para la variable del modelo.
        ModelAndView modelo;
        try{
            //Creación del objeto modelo y asignación de la vista login.
            modelo = new ModelAndView( "login" );
        }catch( Exception e ){
            LOGGER.error( "ERROR:" + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject( "ERROR: " + e.getMessage() );
        }
        return modelo;
    }//End Method
    
    /**
     * Método que canaliza hacia la lógica de StartBusiness.
     * @author avilchis
     * @date 2018-10-24.
     * @param request guarda variables de sesión
     * @param response devuelve cookies
     * @param userName parametro para utilizar
     * @param passwd parametro para utilizar
     * @return modelo
     */
    @RequestMapping( value = {"/login"},  method = {RequestMethod.POST} )
    @ResponseBody
    public ModelAndView getLogin( HttpServletRequest request, HttpServletResponse response,
             @RequestParam( value = "userName", required = true ) String userName, 
             @RequestParam( value = "passwd", required = true) String passwd){
        //Definción para la variable del modelo.
        ModelAndView modelo = null;
        try{
            //Se realiza el enlace con la capa de negocio.
            modelo = gobStartBusiness.getLogin( modelo, request, response, userName, passwd);
        }catch( Exception e ){
            LOGGER.error( "ERROR:" + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message" + e.getMessage() );
        }
        return modelo;
    }//End Method
    
    /**
     * Método que muestra la página de user.htm.
     * @author avilchis
     * @date 2018-10-24.
     * @param request
     * @param response
     * @return modelo
     */
    @RequestMapping( value = {"/user"},  method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView user( HttpServletRequest request, HttpServletResponse response ){
        //Definción para la variable del modelo.
        ModelAndView modelo;
        try{
            //Creación del objeto modelo y asignación de la vista user.
            modelo = new ModelAndView( "user" );
        }catch( Exception e ){
            LOGGER.error( "ERROR:" + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject( "ERROR: " + e.getMessage() );
        }
        return modelo;
    }//End Method
    
}//End Class
