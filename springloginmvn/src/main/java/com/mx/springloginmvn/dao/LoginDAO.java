/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.springloginmvn.dao;

import com.mx.springloginmvn.model.LoginVO;
import org.apache.log4j.Logger;

/**
 *
 * @author avilchis
 */
public class LoginDAO {
    private static final Logger LOGGER = Logger.getLogger( LoginDAO.class );
    

    public LoginVO getLogin(String user, String passwd) {
        System.out.println("getLogin()DAO");
        LoginVO lobRespuesta = null;
        try{
            lobRespuesta = getUserLogin();
            if( lobRespuesta.getUser() != null || !lobRespuesta.getUser().isEmpty() ||
                    lobRespuesta.getPassword() != null || !lobRespuesta.getPassword().isEmpty() ){
                LOGGER.info("...se han recuperado datos del usuario");
                return lobRespuesta;
            }else{
                LOGGER.info("...no se han recuperado datos del usuario");
            }
        }catch( Exception e ){
            LOGGER.error("ERROR: " + e, e);
        }
        return lobRespuesta;
    }

    private LoginVO getUserLogin() {
        LoginVO loginVO = new LoginVO();
        LOGGER.info("Obteniendo información del usuario...");
        return loginVO;
    }
    
}
