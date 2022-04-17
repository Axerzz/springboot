package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{username}")
    User selectByUsername(User user);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    int insert(User user);
}
