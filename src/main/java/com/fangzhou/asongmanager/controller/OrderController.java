package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.OrderService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/getAllOrder")
    public Msg getAllOrder(@RequestParam("pn")Integer pn){
        Msg msg = orderService.getAllOrder(pn);
        return msg;
    }

    @PostMapping("/SelOrderBymohu")
    public Msg SelOrderBymohu(@RequestParam("username")String username,
                              @RequestParam("timescope")String timescope,
                              @RequestParam("state")Integer state,
                              @RequestParam("pn")Integer pn){
        Msg msg = orderService.SelOrderBymohu(username,timescope,state,pn);
        return msg;
    }
}


