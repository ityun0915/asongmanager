package com.fangzhou.asongmanager.dto;

import lombok.Data;

@Data
public class ProCommontDTO {
    private Long id;            //id
    private String context;     //评论内容
    private String pro_name;    //评论作品名
    private String author;      //评论作者
    private String username;     //用户昵称
    private String create_time;   //评论时间
}
