/*******************************************************************************
 *                                                                             *
 *                          AngelVG, Test 2018                                 *
 *                                                                             *
 ******************************************************************************/
package com.mx.springloginmvn.model;

/**
 *
 * @author avilchis
 */
public class LoginVO {
    
    private String user;
    
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public LoginVO(){
        this.user = "Angel";
        this.password = "vilchis";
    }
    
}
