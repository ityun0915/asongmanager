package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.PinlunService;
import com.fangzhou.asongmanager.dto.ProCommontDTO;
import com.fangzhou.asongmanager.mapper.AuthorMapper;
import com.fangzhou.asongmanager.mapper.PinlunMapper;
import com.fangzhou.asongmanager.mapper.ProductMapper;
import com.fangzhou.asongmanager.mapper.UserMapper;
import com.fangzhou.asongmanager.pojo.ProCommont;
import com.fangzhou.asongmanager.pojo.Product;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PinlunServiceImpl implements PinlunService {

    @Autowired
    private PinlunMapper pinlunMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Msg getAllPinlun(Integer pn) {
        List<ProCommontDTO> list = new ArrayList<>();
        List<ProCommont> result = pinlunMapper.getAllPinlun();
        for (ProCommont proCommont:result){
            ProCommontDTO proCommontDTO = new ProCommontDTO();
            //设置评论id
            proCommontDTO.setId(proCommont.getId());
            //设置评论
            proCommontDTO.setContext(proCommont.getContext());
            //设置作品名
            Long pro_id = proCommont.getPro_id();
            Product product = productMapper.SelProductById(pro_id);
            proCommontDTO.setPro_name(product.getTitle());
            //设置作者
            Long author_id = product.getAuthor_id();
            String author_name = authorMapper.getNameById(author_id);
            proCommontDTO.setAuthor(author_name);
            //设置用户昵称
            String username = userMapper.getUsernameById(proCommont.getUser_id());
            proCommontDTO.setUsername(username);
            //设置评论 时间
            proCommontDTO.setCreate_time(proCommont.getCreate_time());

            list.add(proCommontDTO);
        }
        Map<String, Object> commontDTOMaps = PagesMap.getCommontDTOMaps(list, pn);
        Msg msg = Msg.success().add("list",commontDTOMaps);

        return msg;
    }

    @Override
    public Msg DelPinlun(Long id) {
//        System.out.println("删除serimpl");
        pinlunMapper.DelPinlun(id);
        return Msg.success();
    }

    @Override
    public Msg SelPinlunBymohu(String username, Integer pn) {
        List<ProCommontDTO> list = new ArrayList<>();
        List<ProCommont> result = pinlunMapper.SelPinlunBymohu(username);
        for (ProCommont proCommont:result){
            ProCommontDTO proCommontDTO = new ProCommontDTO();
            //设置评论id
            proCommontDTO.setId(proCommont.getId());
            //设置评论
            proCommontDTO.setContext(proCommont.getContext());
            //设置作品名
            Long pro_id = proCommont.getPro_id();
            Product product = productMapper.SelProductById(pro_id);
            proCommontDTO.setPro_name(product.getTitle());
            //设置作者
            Long author_id = product.getAuthor_id();
            String author_name = authorMapper.getNameById(author_id);
            proCommontDTO.setAuthor(author_name);
            //设置用户昵称
            String name = userMapper.getUsernameById(proCommont.getUser_id());
            proCommontDTO.setUsername(name);
            //设置评论 时间
            proCommontDTO.setCreate_time(proCommont.getCreate_time());

            list.add(proCommontDTO);
        }
        Map<String, Object> commontDTOMaps = PagesMap.getCommontDTOMaps(list, pn);
        Msg msg = Msg.success().add("list",commontDTOMaps);

        return msg;
    }
}
