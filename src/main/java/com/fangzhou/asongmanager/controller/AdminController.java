package com.fangzhou.asongmanager.controller;

import com.fangzhou.asongmanager.Service.AdminService;
import com.fangzhou.asongmanager.pojo.Admin;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

        @PostMapping("/AdminLogin")         //管理员登录
        public Msg AdminLogin(@RequestParam("username") String username,@RequestParam("password") String password){
//            System.out.println("有用户登陆：username："+username);
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
        System.out.println("管理员:"+admin.getUsername()+"正在登陆："+admin);

        Msg msg = adminService.AdminLogin(admin);

        return msg;
    }

    @PostMapping("/getAllAdmin")        //查询所有管理员
    public Msg getAllAdmin(@RequestParam("pn") Integer pn){
            return adminService.getAllAdmin(pn);
    }
    @PostMapping("/DelAdmin")               //根据id删除管理员
    public Msg DelAdmin(@RequestParam("id")Integer id){
            return adminService.DelAdmin(id);
    }
    @PostMapping("/SelAdminBymohu")         //username或phone查询管理员
    public Msg SelAdminBymohu(@RequestParam("username") String username,@RequestParam("pn") Integer pn){
//            System.out.println("模糊查询:"+username+"页数:"+pn);
        Msg msg = adminService.SelAdminBymohu(username,pn);
        return msg;
    }
    @PostMapping("/SeluserById")
    public Msg SeluserById(@RequestParam("id")Integer id){
            Msg msg = adminService.SeluserById(id);
            return msg;
    }

    @PostMapping("/UpdateAdmin")
    public Msg UpdateAdmin(Admin admin){
            System.out.println("修改管理员信息:"+admin);
            Msg msg = adminService.UpdateAdmin(admin);
            return msg;
    }
    @PostMapping("/addAdmin")
    public Msg addAdmin(Admin admin){
            System.out.println("添加的管理员信息:"+admin);
            Msg msg = adminService.addAdmin(admin);
            return msg;
    }
}
