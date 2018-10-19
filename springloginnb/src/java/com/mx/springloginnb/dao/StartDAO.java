/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.springloginnb.dao;

import com.mx.springloginnb.model.LoginParams;
import org.apache.log4j.Logger;

/**
 *
 * @author avilchis
 */
public class StartDAO {

    private static final Logger LOGGER = Logger.getLogger(StartDAO.class);

    public String getLogin(String user, String password) {

        LoginParams loginData = null;
        String loginParam = "";
        try {
            loginData = getUserLogin();
            if (loginData.getUserName() != null || !loginData.getUserName().isEmpty()
                    || loginData.getPasswd() != null || !loginData.getPasswd().isEmpty()) {
                loginParam = loginData.getUserName() + loginData.getPasswd();
                LOGGER.info("...los datos se obtivueron correctamente");
                return loginParam;
            } else {
                loginParam = null;
                LOGGER.error("ERROR: " + "Ocurrio un error en el servidor");
            }
        } catch (Exception e) {
            LOGGER.error("ERROR: " + e, e);
        }

        return loginParam;

    }

    public LoginParams getLogin2(String user, String password) {

        LoginParams loginData = null;
        try {
            loginData = getUserLogin();
            if (loginData.getUserName() != null || !loginData.getUserName().isEmpty()
                    || loginData.getPasswd() != null || !loginData.getPasswd().isEmpty()) {
                LOGGER.info("...los datos se obtivueron correctamente");
                return loginData;
            } else {
                LOGGER.error("ERROR: " + "Ocurrió un error en el servidor");
            }
        } catch (Exception e) {
            LOGGER.error("ERROR: " + e, e);
        }
        return loginData;
    }

    public LoginParams getUserLogin() {

        LoginParams loginData = new LoginParams();
        LOGGER.info("Obteniendo datos...");
        //System.out.println("loginData: " + loginData.getUserName()+ " " + loginData.getPasswd());

        return loginData;
    }

//    public static void main(String args[]){
//        StartDAO strDAO = new StartDAO();
//        strDAO.getUserLogin();
//    }
}
