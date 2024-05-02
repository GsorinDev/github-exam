package com.siplify.exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoMVCController {

    public String displayMessage()
    {
        return "Hello Ynov";
    }

    @GetMapping("/ynov")
    public String displayMessageHTML() {
        return "ynov/ynov";
    }
}
