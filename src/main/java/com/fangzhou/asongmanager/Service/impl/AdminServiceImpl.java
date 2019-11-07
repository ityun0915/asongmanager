package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.AdminService;
import com.fangzhou.asongmanager.mapper.AdminMapper;
import com.fangzhou.asongmanager.pojo.Admin;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Msg AdminLogin(Admin admin) {
        Admin result = adminMapper.selAdmin(admin);
        if (result != null){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @Override
    public Msg getAllAdmin(Integer pn) {
        List<Admin> list = adminMapper.getAllAdmin();
        Map<String, Object> pageInfo = PagesMap.getpagesUserMaps(list, pn);
        return Msg.success().add("list",pageInfo);
    }

    @Override
    public Msg DelAdmin(Integer id) {
        adminMapper.DelAdmin(id);
        System.out.println("成功删除id为"+id+"的管理员!");
        return Msg.success();
    }

    @Override
    public Msg SelAdminBymohu(String username,Integer pn) {
       List<Admin> result = adminMapper.SelAdminBymohu(username);
//       for (Admin admin:result){
//           System.out.println("admin:"+admin);
//       }
        Map<String, Object> map = PagesMap.getpagesUserMaps(result, pn);
        return Msg.success().add("list",map);
    }

    @Override
    public Msg SeluserById(Integer id) {
        Admin admin = adminMapper.SeluserById(id);
        return Msg.success().add("user",admin);
    }

    @Override
    public Msg UpdateAdmin(Admin admin) {
        adminMapper.UpdateAdmin(admin);
        return Msg.success();
    }

    @Override
    public Msg addAdmin(Admin admin) {

        Admin admin1 = adminMapper.selAdminByName(admin.getUsername());
        if (admin1 != null){
            return Msg.fail().add("list","占用");
        }
        adminMapper.addAdmin(admin);
        return Msg.success();
    }
}
