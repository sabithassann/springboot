package com.sabit.studentcrud.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllers implements ErrorController {


    @RequestMapping("/error")
    public String handleError() {
        // Custom error handling logic or return a specific error view
        return "errorPage"; // Replace with your error page name
    }



}
