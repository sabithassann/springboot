package com.sabit.nexchain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/")
    public String index(){
        return  "base";

        }

    @GetMapping("/demo")
    public String base(){
        return  "base/demo";

    }
}
