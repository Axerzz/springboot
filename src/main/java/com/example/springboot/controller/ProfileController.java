package com.example.springboot.controller;

import com.example.springboot.entity.Profile;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.ProfileMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")

public class ProfileController {
    @Resource
    ProfileMapper profileMapper;

    @GetMapping
    public Profile select(@RequestParam String username)
    {
        Profile tmp = profileMapper.selectByUsername(username);
        return tmp;
    }

    @PutMapping
    public boolean save(@RequestBody Profile profile)
    {
        System.out.println(profile);
        int t = profileMapper.updateOne(profile);
        return true;
    }

    @PostMapping
    public boolean create(@RequestBody User user)
    {
        Profile profile = new Profile();
        profile.setUsername(user.getUsername());
        profileMapper.insert(profile);
        return true;
    }
}
