package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Profile;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProfileMapper extends BaseMapper<Profile> {

    @Select("select * from profile where username=#{username}")
    Profile selectByUsername(String username);

    @Update("update profile set mobile=#{mobile},email=#{email},age=#{age},carnum=#{carnum}," +
            "lng=#{lng},lat=#{lat} where username=#{username}")
    int updateOne(Profile profile);

}
