package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.dto.AdvertisingDTO;
import com.fangzhou.asongmanager.utils.Msg;

public interface AdvertisServcie {
    Msg getAllAdvertis(Integer pn);
    Msg SelAdvertisBymohu(String username,Integer pn);
    Msg addAdvertis(AdvertisingDTO advertisingDTO);
    Msg DelAdvertis(Integer id);
    Msg SelAdvertisById(Long id);
    Msg UpdateAdvertis(AdvertisingDTO advertisingDTO);
}
