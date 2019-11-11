package com.fangzhou.asongmanager.Service.impl;

import com.fangzhou.asongmanager.Service.HomeService;
import com.fangzhou.asongmanager.dto.HomeNumDTO;
import com.fangzhou.asongmanager.dto.HomeRealtimeDTO;
import com.fangzhou.asongmanager.mapper.*;
import com.fangzhou.asongmanager.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private ReferralsMapper referralsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 获取首页数据
     * @return
     */
    @Override
    public Msg getAllnum() {
        Map<String,Object> map = new HashMap<>();
        //获取首页作品数据
        HomeNumDTO product = new HomeNumDTO();
        HomeNumDTO author = new HomeNumDTO();
        HomeNumDTO referrals = new HomeNumDTO();
        HomeNumDTO user = new HomeNumDTO();
        HomeNumDTO order = new HomeNumDTO();

        /**
         *  获取首页作品数据
         */
        int pro_num = productMapper.getProNum();
        //获取今日新增作品数 SELECT COUNT(1) FROM product WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        int pro_today = productMapper.getTodayNum();
        //获取本周新增作品数 SELECT COUNT(1) FROM product WHERE WEEK(create_time) = WEEK(NOW())
        int pro_week = productMapper.getWeekNum();
        //获取本月新增作品数  SELECT COUNT(1) FROM product WHERE MONTH(create_time) = MONTH(NOW())
        int pro_month = productMapper.getMonthNum();
        product.setNum(pro_num);
        product.setToday(pro_today);
        product.setWeek(pro_week);
        product.setMonth(pro_month);
        map.put("product",product);

        /**
         * 获取首页作者数据
         */
        //获取作者总数
        int author_num = authorMapper.getAuthorNum();
        //获取今日新增作者数 SELECT COUNT(1) FROM author WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        int author_today = authorMapper.getTodayNum();
        //获取本周新增作者数  SELECT COUNT(1) FROM author WHERE week(create_time) = week(NOW())
        int author_week = authorMapper.getWeekNum();
        //获取本月新增作者数 SELECT COUNT(1) FROM author WHERE month(create_time) = month(NOW())
        int author_month = authorMapper.getMonthNum();
        author.setNum(author_num);
        author.setToday(author_today);
        author.setWeek(author_week);
        author.setMonth(author_month);
        map.put("author",author);

        /**
         * 获取首页推荐人数据
         */
        //获取推荐人总数
        int refer_num = referralsMapper.getReferNum();
        //获去今日新增推荐人数 SELECT COUNT(1) FROM referrals WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        int refer_today = referralsMapper.getTodayNum();
        //获取本周新增推荐人数 SELECT COUNT(1) FROM referrals WHERE week(create_time) = week(NOW())
        int refer_week = referralsMapper.getWeekNum();
        //获取本月新增推荐人数 SELECT COUNT(1) FROM referrals WHERE month(create_time) = month(NOW())
        int refer_month = referralsMapper.getMonthNum();
        referrals.setNum(refer_num);
        referrals.setToday(refer_today);
        referrals.setWeek(refer_week);
        referrals.setMonth(refer_month);
        map.put("referrals",referrals);

        /**
         * 获取首页用户数据
         */
        //获取推荐人总数
        int user_num = userMapper.getUserNum();
        //获去今日新增用户人数 SELECT COUNT(1) FROM user WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        int user_today = userMapper.getTodayNum();
        //获取本周新增用户人数 SELECT COUNT(1) FROM user WHERE week(create_time) = week(NOW())
        int user_week = userMapper.getWeekNum();
        //获取本月新增用户人数 SELECT COUNT(1) FROM user WHERE month(create_time) = month(NOW())
        int user_month = userMapper.getMonthNum();
        user.setNum(user_num);
        user.setToday(user_today);
        user.setWeek(user_week);
        user.setMonth(user_month);
        map.put("user",user);

        /**
         * 获取首页订单数据
         */
        //获取推荐人总数
        int order_num = orderMapper.getOrderNum();
        //获去今日新增用户人数 SELECT COUNT(1) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        int order_today = orderMapper.getTodayNum();
        //获取本周新增用户人数 SELECT COUNT(1) FROM asong_order WHERE week(create_time) = week(NOW())
        int order_week = orderMapper.getWeekNum();
        //获取本月新增用户人数 SELECT COUNT(1) FROM asong_order WHERE month(create_time) = month(NOW())
        int order_month = orderMapper.getMonthNum();
        order.setNum(order_num);
        order.setToday(order_today);
        order.setWeek(order_week);
        order.setMonth(order_month);
        map.put("order",order);

        Msg msg = Msg.success().add("list",map);
        return msg;
    }

    @Override
    public Msg getRealtime() {
        Map<String,Object> map = new HashMap<>();
        HomeRealtimeDTO sales = new HomeRealtimeDTO();
        HomeRealtimeDTO order1 = new HomeRealtimeDTO();
        HomeRealtimeDTO order0 = new HomeRealtimeDTO();
//        HomeRealtimeDTO fangwen = new HomeRealtimeDTO();

        /**
         * 获取首页今日销售额
         */
        //获取今日销售额 SELECT SUM(money) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW()) AND state>0
        String sales_today = orderMapper.getTodaysales();
        //获取昨日销售额  SELECT SUM(money) FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1 AND state>0
        String sales_yesterday = orderMapper.getYesterdaysales();
//        System.out.println("今日销售额:"+sales_today);
//        System.out.println("昨日销售额:"+sales_yesterday);
        sales.setToday(sales_today);
        sales.setYesterday(sales_yesterday);
        map.put("sales",sales);

        /**
         * 获取首页支付订单数
         */
        //获取今日支付订单数 SELECT COUNT(1) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW()) AND state>0
        String pay_today= orderMapper.getTodaypay();
        //获取昨天支付订单数 SELECT COUNT(1) FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1 AND state>0
        String pay_yesterday= orderMapper.getYesterdaypay();
        order1.setToday(pay_today);
        order1.setYesterday(pay_yesterday);
        map.put("order1",order1);

        /**
         * 获取首页下单用户
         */
        //获取今日下用户 SELECT COUNT(1) FROM asong_order WHERE TO_DAYS(create_time) = TO_DAYS(NOW())
        String order0_today = orderMapper.getTodayOrder0();
        //获取昨日下单用户  SELECT COUNT(1)  FROM asong_order WHERE TO_DAYS(NOW())- TO_DAYS(create_time) = 1
        String order0_yesterday = orderMapper.getYesterdayOrder0();
        order0.setToday(order0_today);
        order0.setYesterday(order0_yesterday);
        map.put("order0",order0);

        Msg msg = Msg.success().add("list",map);
        return msg;
    }
}
