package com.fangzhou.asongmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

  private Long id;
  private String birth;
  private String city;
  private Date create_time;
  private String district;
  private String header;
  private Boolean is_author;
  private String name;
  private String openid;
  private String province;
  private String referrals;
  private int state;
  private Date update_time;
  private String phone;
  private Boolean is_man;

}
