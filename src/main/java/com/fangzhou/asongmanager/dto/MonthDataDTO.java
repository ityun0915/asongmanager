package com.fangzhou.asongmanager.dto;

import lombok.Data;

@Data
public class MonthDataDTO {
    private String city;       //城市
    private int author_count;   //作者人数
    private int product_count; //作品数
    private int sales_count;   //销售量
    private int down_count;     //下载量

}
