package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin selAdmin(Admin admin);

    @Select("select * from  admin")
    List<Admin> getAllAdmin();

    @Delete("delete from admin where id = #{id}")
    void DelAdmin(Integer id);

    @Select("select * from admin where username like CONCAT('%',#{username},'%') or phone like CONCAT('%',#{name},'%')")
    List<Admin> SelAdminBymohu(String username);

    @Select("select * from admin where id=#{id}")
    Admin SeluserById(Integer id);

    @Update("update admin set username=#{username},password=#{password},phone=#{phone},email=#{email},juese=#{juese} where id=#{id}")
    void UpdateAdmin(Admin admin);

    @Update("insert into admin(username,password,phone,email,juese) values(#{username},#{password},#{phone},#{email},#{juese})")
    void addAdmin(Admin admin);

    @Select("select * from admin where username=#{username}")
    Admin selAdminByName(String username);
}
