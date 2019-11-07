package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.dto.ProductDTO;
import com.fangzhou.asongmanager.utils.Msg;

public interface ProductService {
     Msg getAllPro(Integer pn);
     Msg SelProBymohu(String username,Integer category,Integer state,Integer pn);
     Msg SelTypeCate();
     Msg SelProductById(Integer id);
     Msg UpdateProduct(ProductDTO productDTO);
     Msg delProduct(Integer id);
}
