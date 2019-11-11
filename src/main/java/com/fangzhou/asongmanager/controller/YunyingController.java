package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.YunyingService;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yunying")
public class YunyingController {

    @Autowired
    private YunyingService yunyingService;

    @PostMapping("/getAllProType")
    public Msg getAllProType(@RequestParam("pn") Integer pn){
        Msg msg = yunyingService.getAllProType(pn);
        return msg;
    }

    @PostMapping("/SelProTypeBymohu")
    public Msg SelProTypeBymohu(@RequestParam("username")String username,
                         @RequestParam("pn") Integer pn){
        Msg msg =yunyingService.SelProTypeBymohu(username,pn);
        return msg;
    }

    @PostMapping("/DelProType")
    public Msg DelProType(@RequestParam("id") Integer id){
        Msg msg = yunyingService.DelProType(id);
        return msg;
    }

    @PostMapping("/UpdateProType")
    public Msg UpdateProType(@RequestParam("id") Integer id,
                      @RequestParam("protype") String protype){
        Msg msg = yunyingService.UpdateProType(id,protype);
        return msg;
    }

    @PostMapping("/selProTypeNameById")
    public Msg selProTypeNameById(@RequestParam("id") Integer id){
        Msg msg = yunyingService.selProTypeNameById(id);
        return msg;
    }

    @PostMapping("/addProType")
    public Msg addProType(@RequestParam("protype")String protype){
        Msg msg = yunyingService.addProType(protype);
        return msg;
    }
}
