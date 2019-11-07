package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.AuthorService;
import com.fangzhou.asongmanager.dto.AuthorDTO;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/getAllAuthor")
    public Msg getAllAuthor(@RequestParam("pn")Integer pn){
        System.out.println("获取所有作者");
        Msg msg = authorService.getAllAuthor(pn);
        return msg;
    }

    @PostMapping("/DelAuthor")
    public Msg DelAuthor(@RequestParam("id")Integer id){
        Msg msg = authorService.delAuthor(id);
        return msg;
    }

    @PostMapping("/SelAuthorBymohu")
    public Msg SelAuthorBymohu(@RequestParam("username")String username,@RequestParam("pn")Integer pn){
//        System.out.println("作者模糊查询");
        Msg msg = authorService.SelAuthorBymohu(username,pn);
        return msg;
    }
    @PostMapping("/SelAuthorById")
    public Msg SelAuthorById(@RequestParam("id") Integer id){
        Msg msg = authorService.SelAuthorById(id);
        return msg;
    }
    @PostMapping("/UpdateAdmin")
    public Msg UpdateAdmin(@RequestParam("id")Long id,
                           @RequestParam("username")String name,
                           @RequestParam("yiji")String province,
                           @RequestParam("erji")String city,
                           @RequestParam("referrals")String referrals,
                           @RequestParam("like_count")Integer like_count,
                           @RequestParam("product_count")Integer product_count,
                           @RequestParam("down_count")Integer down_count){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(id);
        authorDTO.setName(name);
        authorDTO.setProvince(province);
        authorDTO.setCity(city);
        authorDTO.setReferrals(referrals);
        authorDTO.setProduct_count(product_count);
        authorDTO.setLike_count(like_count);
        authorDTO.setDown_count(down_count);
        return authorService.UpdateAdmin(authorDTO);
    }
}
