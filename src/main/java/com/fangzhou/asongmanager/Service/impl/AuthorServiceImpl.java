package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.AuthorService;
import com.fangzhou.asongmanager.dto.AuthorDTO;
import com.fangzhou.asongmanager.mapper.AuthorMapper;
import com.fangzhou.asongmanager.mapper.ProductMapper;
import com.fangzhou.asongmanager.pojo.Author;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Msg getAllAuthor(Integer pn) {
        System.out.println("serviceImpl的getAllAuthor");

        List<AuthorDTO> list = new ArrayList<>();

        List<Author> result = authorMapper.getAllAuthor();
        for (Author author:result){
            AuthorDTO authorDTO = new AuthorDTO();
//            BeanUtils.copyProperties(author,authorDTO);
            authorDTO.setId(author.getId());
            authorDTO.setName(author.getName());
            authorDTO.setProvince(author.getProvince());
            authorDTO.setCity(author.getCity());
            authorDTO.setReferrals(author.getReferrals());

            //查询出该作者:作品量,关注量,下载量
            int product_count = productMapper.getProCountByAuthorId(author.getId());
            int like_count = productMapper.getComCountByAuthorId(author.getId());
            int down_count = productMapper.getDownCountByAuthor(author.getId());
//System.out.println("like_count"+like_count+"==down_count："+down_count);
            authorDTO.setProduct_count(product_count);
            authorDTO.setLike_count( like_count);
            authorDTO.setDown_count(down_count);
            System.out.println("authorDTO:"+authorDTO);
            list.add(authorDTO);
        }
        Map<String, Object> authorMaps = PagesMap.getAuthorMaps(list, pn);
        return Msg.success().add("list",authorMaps);
    }

    @Override
    public Msg delAuthor(Integer id) {
        authorMapper.delAuthor(id);
        return Msg.success();
    }

    @Override
    public Msg SelAuthorBymohu(String username, Integer pn) {
        List<AuthorDTO> list = new ArrayList<>();
        List<Author> result = authorMapper.SelAuthorBymohu(username);
        for (Author author:result){
            AuthorDTO authorDTO = new AuthorDTO();
            BeanUtils.copyProperties(author,authorDTO);
            list.add(authorDTO);
        }
        Map<String, Object> authorMaps = PagesMap.getAuthorMaps(list, pn);
        return Msg.success().add("list",authorMaps);
    }

    @Override
    public Msg SelAuthorById(Integer id) {
        AuthorDTO authorDTO = new AuthorDTO();
        Author author = authorMapper.SelAuthorById(id);
        BeanUtils.copyProperties(author,authorDTO);
        Msg msg = Msg.success().add("user",authorDTO);
        return msg;
    }

    @Override
    public Msg UpdateAdmin(AuthorDTO authorDTO) {
        authorMapper.UpdateAdmin(authorDTO);
        return Msg.success();
    }
}
