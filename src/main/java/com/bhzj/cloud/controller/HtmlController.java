package com.bhzj.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/html")
public class HtmlController {


    @GetMapping("/addCommodity")
    public String addCommodity(){
        return "addCommodity";
    }



}
