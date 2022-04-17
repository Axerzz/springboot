package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("profile")
public class Profile {
    private String username;
    private String mobile;
    private String email;
    private String carnum;
    private int age;
    private double lng;
    private double lat;
}
