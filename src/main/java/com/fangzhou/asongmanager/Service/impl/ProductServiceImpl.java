package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.ProductService;
import com.fangzhou.asongmanager.dto.ProductDTO;
import com.fangzhou.asongmanager.mapper.AuthorMapper;
import com.fangzhou.asongmanager.mapper.ProductMapper;
import com.fangzhou.asongmanager.pojo.Product;
import com.fangzhou.asongmanager.pojo.ProductionType;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Msg getAllPro(Integer pn) {
        //创建接收作品dto的list
        List<ProductDTO> productList = new ArrayList<>();

        List<Product> list = productMapper.getAllPro();
        for (Product product:list){
//            System.out.println("所有作品 :"+product);
            ProductDTO pro = new ProductDTO();
            pro.setId(product.getId());
            pro.setTitle(product.getTitle());

            int classId = product.getClass_id();
//            System.out.println("classId:"+classId);
            String type = productMapper.getTypeByClassId(classId);
            pro.setType(type);
            //点赞量,评论,下载,分享 暂时 写o
            pro.setDianzan(product.getGood_num());
            pro.setPinlun(product.getCom_num());
            pro.setXiazai(product.getDown_num());
            pro.setFenxiang(product.getPlay_num());
            Long authorId = product.getAuthor_id();
//            System.out.println("作者id:"+authorId);
            pro.setAuthor(authorMapper.getNameById(authorId));
            pro.setPubTime(product.getCreate_time());
            pro.setState(product.getState());
            pro.setPro_url(product.getPro_url());
            pro.setRecommend(product.getRecommend());
            //将productdto对象存入List<ProductDTO>
            productList.add(pro);
        }

        Map<String, Object> productMaps = PagesMap.getProductMaps(productList, pn);
        Msg msg = Msg.success().add("list", productMaps);
        return msg;
    }

    @Override
    public Msg SelProBymohu(String username,Integer category,Integer state, Integer pn) {
        List<ProductDTO> productList = new ArrayList<>();

        List<Product> list = productMapper.SelProBymohu(username,category,state);
        for (Product product:list){
//            System.out.println("所有作品 :"+product);
            ProductDTO pro = new ProductDTO();
            pro.setId(product.getId());
            pro.setTitle(product.getTitle());

            int classId = product.getClass_id();
//            System.out.println("classId:"+classId);
            String type = productMapper.getTypeByClassId(classId);
            pro.setType(type);
            //点赞量,评论,下载,分享 暂时 写o
            pro.setDianzan(product.getGood_num());
            pro.setPinlun(product.getCom_num());
            pro.setXiazai(product.getDown_num());
            pro.setFenxiang(product.getPlay_num());
            Long authorId = product.getAuthor_id();
//            System.out.println("作者id:"+authorId);
            pro.setAuthor(authorMapper.getNameById(authorId));
            pro.setPubTime(product.getCreate_time());
            pro.setState(product.getState());
            pro.setRecommend(product.getRecommend());

            //将productdto对象存入List<ProductDTO>
            productList.add(pro);
        }

        Map<String, Object> productMaps = PagesMap.getProductMaps(productList, pn);
        return Msg.success().add("list",productMaps);
    }

    @Override
    public Msg SelTypeCate() {
        List<ProductionType> typeList = productMapper.SelTypeCate();
        for (ProductionType type:typeList){
            System.out.println("category:"+type);
        }
        return Msg.success().add("list",typeList);
    }

    @Override
    public Msg SelProductById(Long id) {

        ProductDTO pro = new ProductDTO();

        Product product = productMapper.SelProductById(id);
        System.out.println("product:"+product);
        String nameById = authorMapper.getNameById(product.getAuthor_id());
        BeanUtils.copyProperties(product,pro);
        pro.setAuthor(nameById);
        pro.setDianzan(product.getGood_num());
        pro.setPinlun(product.getCom_num());
        pro.setXiazai(product.getDown_num());
        pro.setFenxiang(product.getPlay_num());
        Msg msg = Msg.success().add("user",pro);
        return msg;
    }

    @Override
    public Msg UpdateProduct(ProductDTO productDTO) {
//        System.out.println("title:"+productDTO.getTitle()+"==type:"+productDTO.getType()+"==author:"+productDTO.getAuthor()+"==state:"+productDTO.getState());
        productMapper.UpdateProduct(productDTO);
        return Msg.success();
    }

    @Override
    public Msg delProduct(Integer id) {
        productMapper.delProduct(id);
        return Msg.success();
    }

    @Override
    public Msg Shangjia(String ids) {

        String[] arr = ids.split(",");
        for (int i=0;i<arr.length;i++){
            productMapper.Shangjia(arr[i]);
        }
        return Msg.success();
    }
    @Override
    public Msg xiajia(String ids) {

        String[] arr = ids.split(",");
        for (int i=0;i<arr.length;i++){
            productMapper.xiajia(arr[i]);
        }
        return Msg.success();
    }
    @Override
    public Msg tuijian(String ids) {

        String[] arr = ids.split(",");
        for (int i=0;i<arr.length;i++){
            productMapper.tuijian(arr[i]);
        }
        return Msg.success();
    }
}
