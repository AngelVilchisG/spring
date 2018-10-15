/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.springnb.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author avilchis
 */
public class LogInfo {
    
    //Logger debe recibir como parametro el nombre de la clase
     private static final Logger LOGGER  = Logger.getLogger(LogInfo.class);
  
    public static void main(String args[] ){
        //Definir la ruta del properties para las salidas al log
        //PropertyConfigurator.configure("log4j.properties");
        
        //SETTING LEVEL LOG
        LOGGER.setLevel(Level.ALL);
     
        LOGGER.info("INFO: " + LOGGER.getLevel());
        //FATAL LEVEL
//        log.fatal("---------------");
//        log.fatal("FATAL LEVEL LOG");
//        log.fatal("---------------");
//       
//        //ERROR LEVEL
//        log.error("---------------");
//        log.error("ERROR LEVEL LOG");
//        log.error("---------------");
//       
//        //INFO LEVEL
//        log.info("---------------");
//        log.info("INFO LEVEL LOG");
//        log.info("---------------");
//       
//        //DEBUG LEVEL
//        log.debug("---------------");
//        log.debug("DEBUG LEVEL LOG");
//        log.debug("---------------");
//        
//        //TRACE LEVEL
//        log.trace("---------------");
//        log.trace("TRACE LEVEL LOG");
//        log.trace("---------------");

    }
}