package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface PinlunService {
    Msg getAllPinlun(Integer pn);
    Msg DelPinlun(Long id);
    Msg SelPinlunBymohu(String username,Integer pn);
}
