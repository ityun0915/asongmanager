package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.DataService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/getAllCityData")
    public Msg getAllCityData(@RequestParam("pn")Integer pn){
        Msg msg = dataService.getAllCityData(pn);
        return msg;
    }

    @PostMapping("/SelCityDataBymohu")
    public Msg SelCityDataBymohu(@RequestParam("year")String year,
                                 @RequestParam("erji")String erji,
                                 @RequestParam("pn")Integer pn){
        System.out.println("year="+year+"&erji="+erji+"&pn="+pn);
        Msg msg = dataService.SelCityDataBymohu(year,erji,pn);
        return msg;
    }

    @PostMapping("/getAllMonthData")
    public Msg getAllMonthData(@RequestParam("pn")Integer pn){
        Msg msg = dataService.getAllMonthData(pn);
        return msg;
    }

    @PostMapping("/SelMonthDataBymohu")
    public Msg SelMonthDataBymohu(@RequestParam("month")String month,
                                 @RequestParam("pn")Integer pn){
        System.out.println("month="+month+"&pn="+pn);
        Msg msg = dataService.SelMonthDataBymohu(month,pn);
        return msg;
    }

    @PostMapping("/getAllReferralsData")
    public Msg getAllReferralsData(@RequestParam("pn")Integer pn){
        Msg msg = dataService.getAllReferralsData(pn);
        return msg;
    }


    @PostMapping("/SelReferralsDataBymohu")
    public Msg SelReferralsDataBymohu(@RequestParam("month")String month,
                                  @RequestParam("pn")Integer pn){
        System.out.println("month="+month+"&pn="+pn);
        Msg msg = dataService.SelReferralsDataBymohu(month,pn);
        return msg;
    }
}
