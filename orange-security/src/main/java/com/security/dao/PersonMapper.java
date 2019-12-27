package com.security.dao;

import com.security.pojo.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

    @Select("select * from person where username= #{username} ")
    Person findUserByName(String username);

}
