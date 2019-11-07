package com.fangzhou.asongmanager.dto;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDTO {
    private String order_num;   //订单号
    private String product_name;  //作品名称
    private int money;      //订单金额
    private String buyer;   //买家名
    private Date create_time;   //交易时间
    private String paytype;     //支付方式
    private int state;          //评价状态



}
