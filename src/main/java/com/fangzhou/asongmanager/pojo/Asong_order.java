package com.fangzhou.asongmanager.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Asong_order {
    private Long id;
    private Date create_time;
    private int money;
    private String order_num;
    private Long product_id;
    private int state;
    private Date update_time;
    private Long user_id;

}
