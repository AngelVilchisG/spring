package com.mx.springlogin.business;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.mx.springlogin.dao.LoginDAO;
import com.mx.springlogin.model.LoginInfoVO;

public class LoginBusiness {
	private static final Logger LOGGER = Logger.getLogger( LoginBusiness.class );
	
	LoginDAO loginDAO = new LoginDAO();

	public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response, String user, String passwd) {
		ModelAndView modelo = null;
		LoginInfoVO logininfo;
		try {
			logininfo = loginDAO.getlogin( user, passwd );
			if( logininfo.getUser() != null || !logininfo.getUser().isEmpty() &&
					logininfo.getPassword() != null || logininfo.getPassword().isEmpty() ) {
				if( logininfo.getUser() == user && logininfo.getPassword() == passwd ){
					LOGGER.info( "El usuario: "+  logininfo.getUser() +", ha iniciado sesión." );
                    modelo = new ModelAndView( "user" );
                    modelo.addObject( "user", logininfo.getUser() );
                    return modelo;
				}else {
					LOGGER.info( "Los datos ingresados son incorrectos" );
                    modelo = new ModelAndView( "user" );
                    modelo.addObject( "message", "Los datos no son correctos" );
				}
			}else {
				LOGGER.info( "No se encontró la información para completar la solicitud" );
                modelo = new ModelAndView( "error" );
                modelo.addObject( "message", "Ocurrio un error en el servidor" );
			}
		}catch( Exception e ) {
			LOGGER.error( "ERROR: " + e, e );
			modelo = new ModelAndView( "error" );
			modelo.addObject( "mesage", e.getMessage() );
		}
		return modelo;
	}

}
