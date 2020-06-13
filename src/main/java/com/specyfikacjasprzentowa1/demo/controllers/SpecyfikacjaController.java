package com.specyfikacjasprzentowa1.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpecyfikacjaController {

    @RequestMapping(value = {"/"})
    public String getComputer() {
        return "index";
    }

}
