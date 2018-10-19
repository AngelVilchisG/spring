/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.springloginmvn.controller;

import com.mx.springloginmvn.business.LoginBusiness;
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
 *
 * @author avilchis
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger( LoginController.class );
   
   LoginBusiness gobLoginBusiness = new LoginBusiness();
    
    @RequestMapping( value = {"/index"}, method = {RequestMethod.GET} )
    public ModelAndView index( HttpServletRequest request, HttpServletResponse response ){
        ModelAndView modelo;
        try{
            modelo = new ModelAndView( "index" );
        }catch( Exception e ){
            LOGGER.error( "ERROR: " + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message", "Ocurrio un error en el servidor" );
        }
        return modelo;
    }
    
    @RequestMapping( value = {"/login"}, method = {RequestMethod.GET} )
    public ModelAndView login( HttpServletRequest request, HttpServletResponse response ){
        ModelAndView modelo;
        try{
            modelo = new ModelAndView( "login" );
        }catch( Exception e ){
            LOGGER.error( "ERROR: " + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message", "Ocurrio un error en el servidor" );
        }
        return modelo;
    }
    
    @RequestMapping( value = {"/login"}, method = {RequestMethod.POST} )
    @ResponseBody
    public ModelAndView getLogin( HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "userName", required = true) String user,
            @RequestParam(value = "passwd", required = true) String passwd){
        System.out.println("-----getLogin()Controller");
        ModelAndView modelo;
        try{
            modelo = gobLoginBusiness.getLogin( request, response, user, passwd);
        }catch( Exception e ){
            LOGGER.error( "ERROR: " + e, e );
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message", "Ocurrio un error en el servidor" );
        }
        return modelo;
    }
    
}