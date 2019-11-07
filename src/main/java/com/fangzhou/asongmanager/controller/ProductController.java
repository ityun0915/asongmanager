package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.ProductService;
import com.fangzhou.asongmanager.dto.ProductDTO;
import com.fangzhou.asongmanager.utils.Msg;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/getAllPro")
    public Msg getAllPro(@RequestParam("pn")Integer pn){
        Msg msg = productService.getAllPro(pn);
        return msg;
    }

    @PostMapping("/SelProBymohu")
    public Msg SelProBymohu(@RequestParam("username")String username,
                            @RequestParam("category")Integer category,
                            @RequestParam("state")Integer state,
                            @RequestParam("pn")Integer pn){
        Msg msg = productService.SelProBymohu(username,category,state,pn);
        return msg;
    }

    @PostMapping("/SelProductById")
    public Msg SelProductById(@RequestParam("id") Integer id){
        Msg msg = productService.SelProductById(id);
        return msg;
    }

    @PostMapping("/getProCates")
    public Msg getProCates(){
        Msg msg = productService.SelTypeCate();
        return msg;
    }

    @PostMapping("/UpdateProduct")
    public Msg UpdateProduct( @RequestParam("id") Long id,
        @RequestParam("title")String title,
        @RequestParam("type")String type,
        @RequestParam("dianzan")int dianzan,
        @RequestParam("pinlun")int pinlun,
        @RequestParam("xiazai")int xiazai,
        @RequestParam("fenxiang")int fenxiang,
        @RequestParam("author")String author,
        @RequestParam("state")Integer state){
System.out.println("id="+id+"&title="+title+"&type="+type+"&dianzan="+dianzan+"&pinlun="+pinlun+"&xiazai="+xiazai+"&fenxiang="+fenxiang+"&author="+author+"&state="+state);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setTitle(title);
        productDTO.setType(type);
        productDTO.setDianzan(dianzan);
        productDTO.setPinlun(pinlun);
        productDTO.setXiazai(xiazai);
        productDTO.setFenxiang(fenxiang);
        productDTO.setAuthor(author);
        productDTO.setState(state);

//        System.out.println("修改作品信息");
        Msg msg = productService.UpdateProduct(productDTO);
        return msg;
    }

    @PostMapping("/delProduct")
    public Msg delProduct(@RequestParam("id")Integer id){
        Msg msg= productService.delProduct(id);
        return msg;
    }
}

