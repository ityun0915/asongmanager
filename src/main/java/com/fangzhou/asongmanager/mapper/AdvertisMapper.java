package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.dto.AdvertisingDTO;
import com.fangzhou.asongmanager.pojo.Advertising;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdvertisMapper {

    @Select("select * from advertising")
    List<AdvertisingDTO> getAllAdvertis();

    @Select("select * from advertising where id like concat('%',#{username},'%') or title like concat('%',#{username},'%')")
    List<AdvertisingDTO> SelAdvertisBymohu(String username);

    @Insert("INSERT INTO advertising (id, img, title, TYPE, url, click_num)VALUES(#{id}, #{img}, #{title}, #{type}, #{url}, #{click_num})")
    void addAdvertis(AdvertisingDTO advertisingDTO);

    @Select("select * from advertising where id= #{id}")
    Advertising SelAdvertisById(Long id);

    @Delete("delete from advertising where id =#{id}")
    void DelAdvertis(Integer id);

    @Update("update advertising set title=#{title},img=#{img},type=#{type},url=#{url},click_num=#{click_num} where id=#{id}")
    void UpdateAdvertis(AdvertisingDTO advertisingDTO);
}
