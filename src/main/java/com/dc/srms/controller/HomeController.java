package com.dc.srms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    String home() {
        return "index";
    }

    @GetMapping("/empty")
    String empty() {
        return "empty";
    }
}
