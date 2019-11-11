package com.fangzhou.asongmanager.mapper;

import com.fangzhou.asongmanager.dto.CityDataDTO;
import com.fangzhou.asongmanager.dto.MonthDataDTO;
import com.fangzhou.asongmanager.dto.ReferralsDataDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {

    @Select("SELECT  \n" +
            "  MONTH (  p.create_time  ) AS month, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND  a.id=p.author_id\n" +
            "GROUP BY  \n" +
            " MONTH ( p.create_time  ) ")
    List<CityDataDTO> getAllCityData();

    @Select("SELECT  \n" +
            "  MONTH (  p.create_time  ) AS month, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time) = #{year} AND a.id=p.author_id AND   a.city=#{erji} \n" +
            "GROUP BY  \n" +
            " MONTH ( p.create_time) ")
    List<CityDataDTO> SelCityDataBymohu(String year,String erji);


    @Select("SELECT  \n" +
            "  a.city AS city, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND  a.id=p.author_id \n" +
            "GROUP BY  \n" +
            " a.city ")
    List<MonthDataDTO> getAllMonthData();


    @Select("SELECT  \n" +
            "  a.city AS city, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  year(p.create_time)=#{year}   and   month(p.create_time)=#{months}  AND  a.id=p.author_id \n" +
            "GROUP BY  \n" +
            " a.city ")
    List<MonthDataDTO> SelMonthDataBymohu(String year,String months);


    @Select("SELECT  \n" +
            "  a.referrals AS referrals, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND  a.id=p.author_id\n" +
            "GROUP BY  \n" +
            " a.referrals ")
    List<ReferralsDataDTO> getAllReferralsData();

    @Select("SELECT  \n" +
            "  a.referrals AS referrals, \n" +
            "  COUNT(distinct a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = #{year} and month(p.create_time)=#{months} AND  a.id=p.author_id \n" +
            "GROUP BY  \n" +
            " a.referrals ")
    List<ReferralsDataDTO> SelReferralsDataBymohu(String year,String months);

    @Select("SELECT COUNT(1) FROM  asong_order o WHERE  MONTH (  o.create_time  ) = #{month} GROUP BY  MONTH ( o.create_time)")
    int getSalesByMonth(String month);

    @Select("SELECT COUNT(1) FROM  asong_order o WHERE  MONTH (  o.create_time  ) = #{month} and year (  o.create_time  ) = #{year} GROUP BY  MONTH ( o.create_time)")
    int getSalesBymohu(String month,String year,String city);

    @Select("SELECT COUNT(1) FROM  asong_order o WHERE  MONTH (  o.create_time  ) = #{month} and year (  o.create_time  ) = #{year} GROUP BY  MONTH ( o.create_time)")
    int SelMonthSalesBymohu(String year,String month);



    @Select("SELECT product_id FROM asong_order")
    String[] getAllProId();

    @Select(" SELECT COUNT(1) FROM product WHERE author_id=(SELECT id FROM author WHERE city='深圳市' GROUP BY id) AND id LIKE CONCAT ('%','-73-','%')")
    int getSalesByStr(String str);
}
