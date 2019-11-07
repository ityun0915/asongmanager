package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.pojo.Admin;
import com.fangzhou.asongmanager.utils.Msg;

public interface AdminService {
    Msg AdminLogin(Admin admin);
    Msg getAllAdmin(Integer pn);
    Msg DelAdmin(Integer id);
    Msg SelAdminBymohu(String username,Integer pn);
    Msg SeluserById(Integer id);
    Msg UpdateAdmin(Admin admin);
    Msg addAdmin(Admin admin);

}
