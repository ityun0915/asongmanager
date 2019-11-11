package com.fangzhou.asongmanager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class Referrals {
    private Long id;
    private String name;
    private int num;        //  推荐人数
    private String create_time;
    private String update_time;

}
