package com.provider.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2019-12-30 13:33
 **/
@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> errot(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("data",e.getMessage());
        map.put("date",new Date());
        return map;
    }
}
