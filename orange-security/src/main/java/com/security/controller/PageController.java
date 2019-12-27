package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cainiao
 * @program: cloud-secutity
 * @description:
 * @create: 2019-12-17 11:56
 **/
@Controller
public class PageController {

    @RequestMapping("/signin")
    public String page(){
        return "signin";
    }
}
