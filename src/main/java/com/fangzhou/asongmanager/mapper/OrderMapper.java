package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.Asong_order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from asong_order")
    List<Asong_order> getAllOrder();

   @Select("select * from asong_order where DATE_SUB(CURDATE(),INTERVAL 30 day) <= DATE(create_time) and order_num like concat('%',#{username},'%') or product_id in (select id from product where title like concat('%',#{username},'%')) and state=#{state} ")
    List<Asong_order> SelOrderBymohu(String username,String timescope,Integer state);
   @Select("select * from asong_order where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(create_time) and order_num like concat('%',#{username},'%') or product_id in (select id from product where title like concat('%',#{username},'%')) and state=#{state} ")
    List<Asong_order> SelOrderBymohu2(String username,String timescope,Integer state);

}
