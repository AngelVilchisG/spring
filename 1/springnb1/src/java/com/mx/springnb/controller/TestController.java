/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.springnb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author avilchis
 */
@Controller
public class TestController {
    public static final Logger log  = Logger.getLogger(TestController.class);
    
    @RequestMapping(value = "/test", method =RequestMethod.GET)
    public ModelAndView start(){
        log.debug("--Entrando en metodo start()");
        ModelAndView modelo = null;
        try{
            modelo = new ModelAndView("test");
            log.info("--Direcciona a pagina test");
        }catch( Exception e ){
            log.error( "--Ocurrio un error de direccionamiento");
        }
        return modelo;
    }
    
}
