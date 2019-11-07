package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.UserService;
import com.fangzhou.asongmanager.mapper.UserMapper;
import com.fangzhou.asongmanager.pojo.User;
import com.fangzhou.asongmanager.utils.Msg;
import com.fangzhou.asongmanager.utils.PagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Msg getAllUser(Integer pn) {
        List<User> list = userMapper.getAllUser();
       /* for(User user:list){
           System.out.println("user:"+user);
            long time = user.getCreate_time().getTime();
            System.out.println("long时间："+time);
            Date date = new Date();
            date.setTime(time);


            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time);
            Date createDate = cal.getTime();
            System.out.println("时间："+createDate);
            user.setCreate_time(createDate);
            }*/

        Map<String, Object> userMaps = PagesMap.getUserMaps(list, pn);
        return Msg.success().add("list",userMaps);
    }

    @Override
    public Msg SelUserBymohu(String username, Integer pn) {
        List<User> result = userMapper.SelUserBymohu(username);
        Map<String, Object> userMaps = PagesMap.getUserMaps(result, pn);
        Msg msg = Msg.success().add("list", userMaps);
        return msg;
    }
}
