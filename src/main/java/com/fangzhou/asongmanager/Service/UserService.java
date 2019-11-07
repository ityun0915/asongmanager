package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.utils.Msg;

public interface UserService {
    Msg getAllUser(Integer pn);
    Msg SelUserBymohu(String username,Integer pn);
}
