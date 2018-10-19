package com.mx.springlogin.dao;

import org.apache.log4j.Logger;

import com.mx.springlogin.model.LoginInfoVO;

public class LoginDAO {
	private static final Logger LOGGER = Logger.getLogger( LoginDAO.class );

	public  LoginInfoVO getlogin(String user, String passwd) {
		LoginInfoVO respuesta = null;
		
		try {
			respuesta = getLoginInfo();
			if( respuesta.getUser() != null || !respuesta.getUser().isEmpty() &&
					respuesta.getPassword() != null || !respuesta.getPassword().isEmpty() ) {
				LOGGER.info( "Se encontró información del usuario" );
				return respuesta;
			}else {
				LOGGER.info( "No se encontró información del usuario" );
				respuesta = null;
			}
		}catch( Exception e) {
			LOGGER.error("ERROR: " + e, e );
		}
		
		return respuesta;
	}

	private LoginInfoVO getLoginInfo() {
		LoginInfoVO loginInfo = new LoginInfoVO();
        LOGGER.info("Obteniendo información del usuario");
        return loginInfo;
	}

}
