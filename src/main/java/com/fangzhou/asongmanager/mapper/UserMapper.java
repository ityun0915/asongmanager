package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where id like concat('%',#{username},'%') or phone like concat('%',#{username},'%')")
    List<User> SelUserBymohu(String username);

    @Select("select name from user where id=#{id}")
    String getUsernameById(Long id);

    @Select("SELECT COUNT(1) FROM user")
    int getUserNum();

    @Select("SELECT COUNT(1) FROM user WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    int getTodayNum();

    @Select("SELECT COUNT(1) FROM user WHERE week(create_time) = week(NOW())")
    int getWeekNum();

    @Select("SELECT COUNT(1) FROM user WHERE month(create_time) = month(NOW())")
    int getMonthNum();
}
