package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.dto.AuthorDTO;
import com.fangzhou.asongmanager.pojo.Author;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Select("select * from author")
    List<Author> getAllAuthor();

    @Delete("delete from author where id=#{id}")
    void delAuthor(Integer id);

    @Select("select * from  author where id like concat('%',#{username},'%') or name like concat('%',#{username},'%')")
    List<Author> SelAuthorBymohu(String username);

    @Select("select * from author where id=#{id}")
    Author SelAuthorById(Integer id);

    @Select("select name from author where id=#{id}")
    String getNameById(Long id);

    @Update("update author set name=#{name},province=#{province},city=#{city},referrals=#{referrals} where id=#{id}")
    void UpdateAdmin(AuthorDTO authorDTO);

    @Select("select count(1) from author")
    int getAuthorNum();

    @Select("SELECT COUNT(1) FROM author WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    int getTodayNum();

    @Select("SELECT COUNT(1) FROM author WHERE week(create_time) = week(NOW())")
    int getWeekNum();

    @Select("SELECT COUNT(1) FROM author WHERE month(create_time) = month(NOW())")
    int getMonthNum();


}
