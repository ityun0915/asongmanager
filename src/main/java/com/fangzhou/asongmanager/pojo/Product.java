package com.fangzhou.asongmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Product {

  private Long id;
  private Long author_id;
  private int class_id;
  private Date create_time;
  private String pro_url;
  private int state;
  private String time;
  private Date update_time;
  private String title;
  private int com_num;
  private int down_num;
  private int good_num;
  private int play_num;



}
