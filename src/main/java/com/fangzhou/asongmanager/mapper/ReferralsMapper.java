package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.pojo.Referrals;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReferralsMapper {

    @Select("select * from referrals")
    List<Referrals> getAllReferrals();

    @Select("select * from referrals where id like concat('%',#{username},'%') or name like concat('%',#{username},'%')")
    List<Referrals> SelReferralsBymohu(String username);

    @Delete("delete from referrals where id =#{id}")
    void DelReferrals(Long id);

    @Select("select count(1) from referrals")
    int getReferNum();

    @Select("SELECT COUNT(1) FROM referrals WHERE TO_DAYS(create_time) = TO_DAYS(NOW())")
    int getTodayNum();

    @Select("SELECT COUNT(1) FROM referrals WHERE week(create_time) = week(NOW())")
    int getWeekNum();

    @Select("SELECT COUNT(1) FROM referrals WHERE month(create_time) = month(NOW())")
    int getMonthNum();
}
