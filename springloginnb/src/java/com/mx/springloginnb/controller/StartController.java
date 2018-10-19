/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.springloginnb.controller;

import com.mx.springloginnb.business.StartBusiness;
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
public class StartController {
    private static final Logger LOGGER = Logger.getLogger( StartController.class );
    
    StartBusiness objBusiness = new StartBusiness();
    
    @RequestMapping( value = {"/index"}, method = {RequestMethod.GET} )
    public ModelAndView start( HttpServletRequest request, HttpServletResponse response ){
        ModelAndView modelo;
        
        try{
            LOGGER.info("/index.htm");
            modelo = new ModelAndView( "index" );
        }catch( Exception e ){
            LOGGER.error("ERROR: " + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject("ERROR: " + e.getMessage() );
        }
        return modelo;
    }
    
    @RequestMapping( value = {"/login"},  method = {RequestMethod.GET} )
    public ModelAndView login( HttpServletRequest request, HttpServletResponse response ){
        ModelAndView modelo;
        
        try{
            LOGGER.info( "/login.htm GET" );
            modelo = new ModelAndView( "login" );
        }catch( Exception e ){
            LOGGER.error( "ERROR:" + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject( "ERROR: " + e.getMessage() );
        }
        return modelo;
    }
    
    @RequestMapping( value = {"/login"},  method = {RequestMethod.POST} )
    @ResponseBody
    public ModelAndView getLogin( HttpServletRequest request, HttpServletResponse response,
             @RequestParam( value = "userName", required = true ) String userName, 
             @RequestParam( value = "passwd", required = true) String passwd){
        ModelAndView modelo;
        
        try{
            LOGGER.info( "get /login.htm POST" );
            modelo = objBusiness.getLogin(request, response, userName, passwd);
        }catch( Exception e ){
            LOGGER.error( "ERROR:" + e, e);
            modelo = new ModelAndView( "error" );
            modelo.addObject( "message" + e.getMessage() );
        }
        return modelo;
    }
    
}
