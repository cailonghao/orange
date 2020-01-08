package com.source.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author cainiao
 * @program: orange-source
 * @description:
 * @create: 2019-12-31 17:59
 **/
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public OAuth2User getUser() {
        return new OAuth2User() {
            @Override
            public Map<String, Object> getAttributes() {
                Map<String,Object> map = new HashMap<>();
                map.put("name","cainiao");
                map.put("sub","sub");
                return map;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> list = new ArrayList<>();
                list.add(((GrantedAuthority)()->"ROLE_USER"));
                return list;
            }

            @Override
            public String getName() {
                return "huahai";
            }
        };
    }

}
