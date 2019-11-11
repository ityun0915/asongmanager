package com.fangzhou.asongmanager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class Product {

  private Long id;
  private Long author_id;
  private int class_id;
  private String create_time;
  private String pro_url;
  private int state;
  private String time;
  private String update_time;
  private String title;
  private int com_num;
  private int down_num;
  private int good_num;
  private int play_num;
  private Boolean recommend;  //推荐位


}
