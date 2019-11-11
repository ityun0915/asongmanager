package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.PinlunService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pinlun")
public class PinlunController {

    @Autowired
    private PinlunService pinlunService;

    @PostMapping("/getAllPinlun")
    public Msg getAllPinlun(@RequestParam("pn")Integer pn){
        Msg msg = pinlunService.getAllPinlun(pn);
        return msg;
    }

    @PostMapping("/DelPinlun")
    public Msg DelPinlun(@RequestParam("id")Long id){
        Msg msg = pinlunService.DelPinlun(id);
        return msg;
    }

    @PostMapping("/SelPinlunBymohu")
    public Msg SelPinlunBymohu(@RequestParam("pn")Integer pn,
                               @RequestParam("username")String username){
        System.out.println("模糊查询评论");
        Msg msg = pinlunService.SelPinlunBymohu(username,pn);
        return msg;
    }
}
