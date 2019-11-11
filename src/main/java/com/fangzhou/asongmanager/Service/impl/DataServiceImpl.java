package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.DataService;
import com.fangzhou.asongmanager.dto.CityDataDTO;
import com.fangzhou.asongmanager.dto.MonthDataDTO;
import com.fangzhou.asongmanager.dto.ReferralsDataDTO;
import com.fangzhou.asongmanager.mapper.DataMapper;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public Msg getAllCityData(Integer pn) {                 //获取所有城市汇总数据
        List<CityDataDTO> result = dataMapper.getAllCityData();
        for (CityDataDTO cityDataDTO:result){
            System.out.println("城市汇总cityDataDTO:"+cityDataDTO);
            //根据月份获取销售量
            int sales = dataMapper.getSalesByMonth(cityDataDTO.getMonth());
            cityDataDTO.setSales_count(sales);
        }
        Map<String, Object> cityDataMaps = PagesMap.getCityDataMaps(result, pn);
        Msg msg = Msg.success().add("list",cityDataMaps);
        return msg;
    }

    @Override
    public Msg SelCityDataBymohu(String year, String erji, Integer pn) {        //城市年份查询城市汇总数据
        List<CityDataDTO> result = dataMapper.SelCityDataBymohu(year,erji);
        for (CityDataDTO cityDataDTO:result){
            System.out.println("模糊城市汇总cityDataDTO:"+cityDataDTO);
            //根据月份获取销售量
            int sales = dataMapper.getSalesBymohu(cityDataDTO.getMonth(),year,erji);
            cityDataDTO.setSales_count(sales);
        }
        Map<String, Object> cityDataMaps = PagesMap.getCityDataMaps(result, pn);
        Msg msg = Msg.success().add("list",cityDataMaps);
        return msg;
    }


    @Override
    public Msg getAllMonthData(Integer pn) {                        //获取所有月度报表数据
        List<MonthDataDTO> result = dataMapper.getAllMonthData();
        for (MonthDataDTO monthDataDTO:result){

//根据月份获取销售量

            //获取订单表所有product_id : SELECT product_id FROM asong_order
            int sales=0;
            String[] str = dataMapper.getAllProId();
            for (int i=0;i<str.length;i++){
                System.out.println("pid:"+str[i]);
                int num = dataMapper.getSalesByStr(str[i]);
                sales = sales+num;
            }
            monthDataDTO.setSales_count(sales);
            System.out.println("月度汇总monthDataDTO:"+monthDataDTO);
        }

        Map<String, Object> monthDataMaps = PagesMap.getMonthDataMaps(result,pn);
        Msg msg = Msg.success().add("list",monthDataMaps);
        return msg;
    }

    @Override
    public Msg SelMonthDataBymohu(String month, Integer pn) {           //年份,月份查询月度报表数据

        //分割month中的年月
        String year = month.split("-")[0];
        String months = month.split("-")[1];
System.out.println("年:"+year+"==月:"+months);
        List<MonthDataDTO> result = dataMapper.SelMonthDataBymohu(year,months);
        for (MonthDataDTO monthDataDTO:result){
            System.out.println("模糊月度汇总monthDataDTO:"+monthDataDTO);
            int sales = dataMapper.SelMonthSalesBymohu(year,months);
            monthDataDTO.setSales_count(sales);
        }
        Map<String, Object> monthDataMaps = PagesMap.getMonthDataMaps(result, pn);
        Msg msg = Msg.success().add("list",monthDataMaps);
        return msg;
    }



    @Override
    public Msg getAllReferralsData(Integer pn) {            //查询推荐人汇总数据
        List<ReferralsDataDTO> result = dataMapper.getAllReferralsData();
        Map<String, Object> referralsDataMaps = PagesMap.getReferralsDataMaps(result, pn);
        Msg msg= Msg.success().add("list",referralsDataMaps);
        return msg;
    }

    @Override
    public Msg SelReferralsDataBymohu(String month, Integer pn) {           //年份,月份查询推荐人汇总数据

        //分割month中的年月
        String year = month.split("-")[0];
        String months = month.split("-")[1];
        System.out.println("年:"+year+"==月:"+months);
        List<ReferralsDataDTO> result = dataMapper.SelReferralsDataBymohu(year,months);
        for (ReferralsDataDTO referralsDataDTO:result){
            System.out.println("模糊推荐人汇总referralsDataDTO:"+referralsDataDTO);
        }
        Map<String, Object> referralsDataMaps = PagesMap.getReferralsDataMaps(result, pn);
        Msg msg = Msg.success().add("list",referralsDataMaps);
        return msg;
    }
}
