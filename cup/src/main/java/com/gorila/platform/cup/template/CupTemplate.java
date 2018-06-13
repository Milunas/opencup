package com.gorila.platform.cup.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CupTemplate {
    @GetMapping
    public String index(){
        return "/";
    }
}
