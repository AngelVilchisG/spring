/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.avilchis.examples.dao;

import com.mx.avilchis.examples.model.LoginParams;
import org.apache.log4j.Logger;

/**
 * StartDAO clase que realiza peticiones a base de datos o consumo de servicios
 * para el procesamiento de lógica de negocio de la aplicación.
 * @author avilchis
 * @date 2018-10-24.
 */
public class StartDAO {
    //Variable utilizada para guardar las salidas al log de la aplicación.
    private static final Logger LOGGER = Logger.getLogger( StartDAO.class );

    /**
     * Función que realiza petición para obtener un objeto de modelo. 
     * @author avilchis
     * @date 2018-10-24.
     * @return LoginParams
     */
    public LoginParams getLogin() {
        //Variable para realizar la solicitud del objeto LoginParams.
        LoginParams lobLoginParams = null;
        try {
            //Realiza petición para obtener objeto de modelo.
            lobLoginParams = getUserLogin();
            if ( lobLoginParams != null ) {//Valida si el objeto contiene información.
                LOGGER.info( "...los datos se obtivueron correctamente." );
                return lobLoginParams;
            } else {//El objeto no contiene información.
                LOGGER.info( "... no se obtivieron datos." );
            }
        } catch ( Exception e ) {
            LOGGER.error( "ERROR: " + e, e );
        }
        return lobLoginParams;
    }//End Method

    /**
     * Función que obtiene un objeto con informacion del modelo.
     * @author avilchis
     * @date 2018-10-24.
     * @return LoginParams
     */
    public LoginParams getUserLogin() {
        //Crea objeto LoginParams
        LoginParams loginData = new LoginParams();
        LOGGER.info( "Obteniendo datos..." );
        return loginData;
    }//End Method

}//End Class
