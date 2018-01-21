package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PointMapper {

    @Insert("INSERT INTO point(uid, num) VALUES(#{uid}, #{num})")
    int insert(@Param("uid") Long uid, @Param("num") Long num);

}
