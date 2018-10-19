package com.mx.springlogin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mx.springlogin.business.LoginBusiness;

@Controller
public class LoginController{
	private static final Logger LOGGER = Logger.getLogger( LoginController.class );

	LoginBusiness loginBusiness = new LoginBusiness();
	
	@RequestMapping( value = {"/index"}, method = {RequestMethod.GET})
	public ModelAndView index( HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView modelo = null;
		try {
			modelo = new ModelAndView( "index" );
		}catch( Exception e ) {
			LOGGER.error("ERROR: " +  e, e );
			modelo = new ModelAndView( "error" ); 
			modelo.addObject( "message", e.getMessage() );
		}
		return modelo;
	}
	
	@RequestMapping( value = {"/login"}, method = {RequestMethod.GET})
	public ModelAndView login( HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView modelo = null;
		try {
			modelo = new ModelAndView( "login" );
		}catch( Exception e ) {
			LOGGER.error("ERROR: " +  e, e );
			modelo = new ModelAndView( "error" ); 
			modelo.addObject( "message", e.getMessage() );
		}
		return modelo;
	}
	
	@RequestMapping( value = {"/login"}, method = {RequestMethod.POST})
	public ModelAndView getLogin( HttpServletRequest request, HttpServletResponse response,
			@RequestParam( value = "userName", required = true ) String user,
			@RequestParam( value = "passwd", required = true ) String passwd) {

		ModelAndView modelo = null;
		try {
			modelo = loginBusiness.getLogin( request, response, user, passwd );
		}catch( Exception e ) {
			LOGGER.error("ERROR: " +  e, e );
			modelo = new ModelAndView( "error" ); 
			modelo.addObject( "message", e.getMessage() );
		}
		return modelo;
	}

}
