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
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id\n" +
            "GROUP BY  \n" +
            " MONTH ( p.create_time  ) ")
    List<CityDataDTO> getAllCityData();

    @Select("SELECT  \n" +
            "  MONTH (  p.create_time  ) AS month, \n" +
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = #{year} AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id and a.city=#{erji} \n" +
            "GROUP BY  \n" +
            " MONTH ( p.create_time  ) ")
    List<CityDataDTO> SelCityDataBymohu(String year,String erji);


    @Select("SELECT  \n" +
            "  a.city AS city, \n" +
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id\n" +
            "GROUP BY  \n" +
            " a.city ")
    List<MonthDataDTO> getAllMonthData();


    @Select("SELECT  \n" +
            "  a.city AS city, \n" +
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  year(p.create_time)=#{year}   and   month(p.create_time)=#{months}  AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id\n" +
            "GROUP BY  \n" +
            " a.city ")
    List<MonthDataDTO> SelMonthDataBymohu(String year,String months);


    @Select("SELECT  \n" +
            "  a.referrals AS referrals, \n" +
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = 2019 AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id\n" +
            "GROUP BY  \n" +
            " a.referrals ")
    List<ReferralsDataDTO> getAllReferralsData();


    @Select("SELECT  \n" +
            "  a.referrals AS referrals, \n" +
            "  COUNT(a.id) AS author_count, \n" +
            "  COUNT(p.id) AS product_count,\n" +
            "  SUM(o.id) AS sales_count,\n" +
            "  SUM( p.down_num  ) AS down_count\n" +
            "FROM  \n" +
            " product p,asong_order o,author a\n" +
            "WHERE  \n" +
            "  YEAR (  p.create_time  ) = #{year} and month(p.create_time)=#{months} AND o.state >= 1 AND  a.id=p.author_id AND  p.id=o.product_id\n" +
            "GROUP BY  \n" +
            " a.referrals ")
    List<ReferralsDataDTO> SelReferralsDataBymohu(String year,String months);

}
