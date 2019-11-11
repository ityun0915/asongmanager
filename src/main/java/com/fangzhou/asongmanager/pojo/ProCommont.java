package com.fangzhou.asongmanager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class ProCommont {

  private Long id;
  private String update_time;
  private String context;
  private String create_time;
  private Long pro_id;
  private Long user_id;
  private int good_num;

}
