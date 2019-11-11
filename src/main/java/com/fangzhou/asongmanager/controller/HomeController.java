package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.HomeService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/getAllnum")
    public Msg getAllnum(){
        Msg msg = homeService.getAllnum();
        return msg;
    }

    @PostMapping("/getRealtime")
    public Msg getRealtime(){
        Msg msg = homeService.getRealtime();
        return msg;
    }
}
