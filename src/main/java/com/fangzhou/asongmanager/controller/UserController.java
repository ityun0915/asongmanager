package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.UserService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getAllUser")
    public Msg getAllUser(@RequestParam("pn") Integer pn){
//        System.out.println("获取所有用户");
        Msg msg = userService.getAllUser(pn);
        return msg;
    }
    @PostMapping("/SelUserBymohu")         //username或phone查询管理员
    public Msg SelUserBymohu(@RequestParam("username") String username,@RequestParam("pn") Integer pn){
//            System.out.println("模糊查询:"+username+"页数:"+pn);
        Msg msg = userService.SelUserBymohu(username,pn);
        return msg;
    }
}
