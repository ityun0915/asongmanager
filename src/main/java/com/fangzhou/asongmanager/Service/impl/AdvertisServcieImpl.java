package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.AdvertisServcie;
import com.fangzhou.asongmanager.dto.AdvertisingDTO;
import com.fangzhou.asongmanager.mapper.AdvertisMapper;
import com.fangzhou.asongmanager.pojo.Advertising;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdvertisServcieImpl implements AdvertisServcie {

    @Value("${ipurl}")
    String ipurl;

    @Autowired
    private AdvertisMapper advertisMapper;

    @Override
    public Msg getAllAdvertis(Integer pn) {
        List<AdvertisingDTO> result = advertisMapper.getAllAdvertis();
        Map<String, Object> advertisDTOMaps = PagesMap.getAdvertisDTOMaps(result, pn);
        Msg msg = Msg.success().add("list",advertisDTOMaps);
        return msg;
    }

    @Override
    public Msg SelAdvertisBymohu(String username, Integer pn) {
        List<AdvertisingDTO> result = advertisMapper.SelAdvertisBymohu(username);
        Map<String, Object> advertisDTOMaps = PagesMap.getAdvertisDTOMaps(result, pn);
        Msg msg = Msg.success().add("list",advertisDTOMaps);
        return msg;
    }

    @Override
    public Msg addAdvertis(AdvertisingDTO advertisingDTO) {
        Long id = advertisingDTO.getId();
        Advertising advertising = advertisMapper.SelAdvertisById(id);
        if (advertising != null){
            return Msg.success().add("list","占用");
        }
        //拼接ip到广告图的img
        String img = advertisingDTO.getImg();
        String img2 = ipurl+"/"+img;
        advertisingDTO.setImg(img2);
        System.out.println("添加的广告:"+advertisingDTO);

        advertisMapper.addAdvertis(advertisingDTO);
        return Msg.success();
    }

    @Override
    public Msg DelAdvertis(Integer id) {
        advertisMapper.DelAdvertis(id);
        return Msg.success();
    }

    @Override
    public Msg SelAdvertisById(Long id) {

        AdvertisingDTO advertisingDTO = new AdvertisingDTO();

        Advertising advertising = advertisMapper.SelAdvertisById(id);
        //将advertising对象封装进dto
        BeanUtils.copyProperties(advertising,advertisingDTO);

        System.out.println("advertisingDTO:"+advertisingDTO);
        Msg msg = Msg.success().add("user",advertisingDTO);
        return msg;
    }

    @Override
    public Msg UpdateAdvertis(AdvertisingDTO advertisingDTO) {

        //拼接ip到广告图的img
        String img = advertisingDTO.getImg();
        String img2 = ipurl+"/"+img;
        advertisingDTO.setImg(img2);
        System.out.println("添加的广告:"+advertisingDTO);

        advertisMapper.UpdateAdvertis(advertisingDTO);
        return Msg.success();
    }
}
