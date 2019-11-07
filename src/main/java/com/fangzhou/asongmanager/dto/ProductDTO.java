package com.fangzhou.asongmanager.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProductDTO {
    private Long id;        //作品id
    private String title;   //作品名称
    private String type;       //作品类型

    private int dianzan;       //点赞量 good_num
    private int pinlun;        //评论量  com_num
    private int xiazai;         //下载量 down_num
    private int fenxiang;      //分享量 play_num
//    private Boolean isTuijian;      //是推荐作品:1是0否
    private String author;       //作者
    private Date pubTime;       //发布时间
    private int state;     //作品状态:1上架0下架

    private String pro_url;     //作品地址

}
