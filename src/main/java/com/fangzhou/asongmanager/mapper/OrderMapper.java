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

    @Select("SELECT COUNT(1) FROM asong_order")
   int getOrderNum();

    @Select("SELECT COUNT(1) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    int getTodayNum();

    @Select("SELECT COUNT(1) FROM asong_order WHERE week(create_time) = week(NOW())")
    int getWeekNum();

    @Select("SELECT COUNT(1) FROM asong_order WHERE month(create_time) = month(NOW())")
    int getMonthNum();

    @Select("SELECT SUM(money) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW()) AND state>0")
    String getTodaysales();

    @Select("SELECT SUM(money) FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1 AND state>0")
    String getYesterdaysales();

    @Select("SELECT COUNT(id) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW()) AND state>0")
    String getTodaypay();

    @Select("SELECT COUNT(id) FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1 AND state>0")
    String getYesterdaypay();

    @Select("SELECT COUNT(id) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    String getTodayOrder0();

    @Select("SELECT COUNT(id)  FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1")
    String getYesterdayOrder0();

}
