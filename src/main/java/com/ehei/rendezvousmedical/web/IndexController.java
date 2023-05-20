package com.ehei.rendezvousmedical.web;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class IndexController implements ErrorController{
    private final static String PATH = "/error";
    @RequestMapping(PATH)
    @ResponseBody
    String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>";
      }
    
    public String getErrorPath() {
      return "/error";
    }

}