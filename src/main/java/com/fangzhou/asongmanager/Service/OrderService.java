package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface OrderService {
    Msg getAllOrder(Integer pn);
    Msg SelOrderBymohu(String username,String timescope,Integer state,Integer pn);
}
