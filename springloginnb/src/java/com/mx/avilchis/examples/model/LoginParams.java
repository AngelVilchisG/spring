/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.avilchis.examples.model;

/**
 *
 * @author avilchis
 */
public class LoginParams {
    
    private String userName;
    private String passwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public LoginParams(){
        this.userName = "Angel";
        this.passwd = "Vilchis";
    }
    
}
