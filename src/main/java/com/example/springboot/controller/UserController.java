package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")

public class UserController {
    @Resource
    UserMapper userMapper;

    @PostMapping("register")
    public Boolean select(@RequestBody User user){
        User tmp = userMapper.selectByUsername(user);
        if(tmp==null){
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    @PostMapping
    public Boolean save(@RequestBody User user){
        User tmp;
        tmp=getUserInfo(user);
        if(tmp==null) return false;
        return true;
    }

    private User getUserInfo(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        User one;
        one = userMapper.selectOne(queryWrapper); // 从数据库查询用户信息
        return one;
    }
}
