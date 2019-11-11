package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.ProCommont;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PinlunMapper {
    @Select("select * from pro_commont")
    List<ProCommont> getAllPinlun();

    @Select("select * from pro_commont where pro_id in (select id from product where title like concat('%',#{username},'%')) or user_id in (select id from user where name like concat('%',#{username},'%'))")
    List<ProCommont> SelPinlunBymohu(String username);

    @Delete("delete from pro_commont where id=#{id}")
    void DelPinlun(Long id);
}
