package com.deerufin.keelungsightsviewer_ver4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
