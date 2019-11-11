package com.fangzhou.asongmanager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class User {

  private Long id;
  private String birth;
  private String city;
  private String create_time;
  private String district;
  private String header;
  private Boolean is_author;
  private String name;
  private String openid;
  private String province;
  private String referrals;
  private int state;
  private String update_time;
  private String phone;
  private Boolean is_man;

}
