package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerVue {

    @GetMapping
    public String homePage(){
        return"home";
    }

    @GetMapping("/createStudent")
    public String createPage(){
        return"createStudent";
    }

    @GetMapping("/listStudent")
    public String listPage(){
        return"listStudent";
    }

    @GetMapping("/detailStudent")
    public String detailPage(){
        return"detailStudent";
    }


}
