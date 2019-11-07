package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface DataService {
    Msg getAllCityData(Integer pn);
    Msg getAllMonthData(Integer pn);
    Msg getAllReferralsData(Integer pn);
    Msg SelCityDataBymohu(String year,String erji,Integer pn);
    Msg SelMonthDataBymohu(String month,Integer pn);
    Msg SelReferralsDataBymohu(String month,Integer pn);
}
