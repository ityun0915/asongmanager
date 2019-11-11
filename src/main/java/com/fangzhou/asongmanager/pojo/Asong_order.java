package com.fangzhou.asongmanager.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Asong_order {
    private Long id;
    private String create_time;
    private int money;
    private String order_num;
    private String product_id;
    private int state;
    private String update_time;
    private Long user_id;

}
