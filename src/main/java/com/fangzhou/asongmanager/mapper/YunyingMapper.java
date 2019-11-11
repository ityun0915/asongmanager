package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.ProductionType;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface YunyingMapper {

    @Select("select * from production_type order by id asc")
    List<ProductionType> getAllProType();

    @Select("select * from production_type where id like concat('%',#{username},'%') or name like concat('%',#{username},'%') order by id asc")
    List<ProductionType> SelProTypeBymohu(String username);

    @Delete("delete from production_type where id=#{id}")
    void DelProType(int id);

    @Update("update production_type set name=#{protype} where id=#{id}")
    void UpdateProType(int id,String protype);

    @Select("select * from production_type where id =#{id}")
    ProductionType selProTypeNameById(Integer id);

    @Select("select * from production_type where name =#{protype}")
    ProductionType selProTypeByName(String protype);

    @Insert("insert into production_type(create_time,name,update_time) values(#{timestamp},#{protype},#{timestamp})")
    void addProType(String protype, Timestamp timestamp);
}
