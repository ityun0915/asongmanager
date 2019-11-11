package com.fangzhou.asongmanager.dto;

import lombok.Data;

@Data
public class ReferralsDTO {
    private Long id;
    private String name;
    private int num;        //  推荐人数
    private String create_time;   //添加时间

}
