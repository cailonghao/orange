package com.provider.controller;

import com.provider.openfeign.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2019-12-30 13:25
 **/
@Slf4j
@RequestMapping
@RestController
public class LoginController {
    @Autowired
    private SecurityService securityService;
    @RequestMapping("/login/date")
    public Map<String,Object> geeToken(@RequestParam String code){
        Map<String,Object> map = new HashMap<>();
        map.put("data",code);
        map.put("date",new Date());
        return map;
    }
}
