package com.fangzhou.asongmanager.dto;

import lombok.Data;

@Data
public class AdvertisingDTO {
    private Long id;            //广告id
    private String title;      //广告标题
    private int type;       //广告类型  1:banner 2:左 3:右
    private String img;         //广告图片
    private String url;     //广告url
    private int click_num;     //点击量
}
