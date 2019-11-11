package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.AdvertisServcie;
import com.fangzhou.asongmanager.dto.AdvertisingDTO;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertis")
public class AdvertisController {

    @Autowired
    private AdvertisServcie advertisServcie;

    @PostMapping("/getAllAdvertis")
    public Msg getAllAdvertis(@RequestParam("pn")Integer pn){
        Msg msg = advertisServcie.getAllAdvertis(pn);
        return msg;
    }

    @PostMapping("/SelAdvertisBymohu")
    public Msg SelAdvertisBymohu(@RequestParam("username")String username,
                                 @RequestParam("pn")Integer pn){
        Msg msg = advertisServcie.SelAdvertisBymohu(username,pn);
        return msg;
    }

    @PostMapping("/addAdvertis")
    public Msg addAdvertis( @RequestParam("id")Long id,
                            @RequestParam("title")String title,
                            @RequestParam("type")Integer type,
                            @RequestParam("url")String url,
                            @RequestParam("click_num")int click_num,
                            @RequestParam("img")String img){

        System.out.println("添加广告");
        AdvertisingDTO advertisingDTO = new AdvertisingDTO();
        advertisingDTO.setId(id);
        advertisingDTO.setTitle(title);
        advertisingDTO.setType(type);
        advertisingDTO.setUrl(url);
        advertisingDTO.setImg(img);
        advertisingDTO.setClick_num(click_num);
        Msg msg = advertisServcie.addAdvertis(advertisingDTO);
        return msg;

    }

    @PostMapping("/DelAdvertis")
    public Msg DelAdvertis(@RequestParam("id")Integer id){
        Msg msg = advertisServcie.DelAdvertis(id);
        return msg;
    }

    @PostMapping("/SelAdvertisById")
    public Msg SelAdvertisById(@RequestParam("id")Long id){
        Msg msg = advertisServcie.SelAdvertisById(id);
        return msg;
    }

    @PostMapping("/UpdateAdvertis")
    public Msg UpdateAdvertis(@RequestParam("id")Long id,
                              @RequestParam("title")String title,
                              @RequestParam("type")Integer type,
                              @RequestParam("url")String url,
                              @RequestParam("click_num")int click_num,
                              @RequestParam("img")String img) {

        System.out.println("更新广告");
        AdvertisingDTO advertisingDTO = new AdvertisingDTO();
        advertisingDTO.setId(id);
        advertisingDTO.setTitle(title);
        advertisingDTO.setType(type);
        advertisingDTO.setUrl(url);
        advertisingDTO.setImg(img);
        advertisingDTO.setClick_num(click_num);
        Msg msg = advertisServcie.UpdateAdvertis(advertisingDTO);
        return msg;
    }

}
