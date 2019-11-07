package com.fangzhou.asongmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Author {

  private Long id;
  private String card_url;
  private String cd_card;
  private String city;
  private Date create_time;
  private String district;
  private String name;
  private String province;
  private String referrals;
  private int state;
  private Date update_time;
  private Long user_id;


}
