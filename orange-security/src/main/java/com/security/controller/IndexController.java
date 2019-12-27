package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cainiao
 * @program: cloud-secutity
 * @description:
 * @create: 2019-12-17 11:43
 **/
@RestController
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "yes , you can";
    }
}
