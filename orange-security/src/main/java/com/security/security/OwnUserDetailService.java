package com.security.security;

import com.security.dao.PersonMapper;
import com.security.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author cainiao
 * @program: cloud-secutity
 * @description: 自定义的认证方式
 * @create: 2019-12-17 15:25
 **/
@Slf4j
public class OwnUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonMapper personMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personMapper.findUserByName(s);
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return person;
    }
}
