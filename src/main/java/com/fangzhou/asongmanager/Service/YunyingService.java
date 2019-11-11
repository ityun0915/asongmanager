package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface YunyingService {
    Msg getAllProType(Integer pn);
    Msg SelProTypeBymohu(String username,Integer pn);
    Msg DelProType(Integer id);
    Msg UpdateProType(Integer id,String protype);
    Msg selProTypeNameById(Integer id);
    Msg addProType(String protype);
}
