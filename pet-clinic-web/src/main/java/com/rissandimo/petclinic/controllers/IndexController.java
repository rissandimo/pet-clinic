package com.rissandimo.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
    @RequestMapping({"", "/", "index", "index.htm"})
    public String index()
    {
        return "index";
    }

    @RequestMapping("/oups")
    public String showOopsPage()
    {
        return "not-implemented";
    }
}
