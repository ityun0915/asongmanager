package com.fangzhou.asongmanager.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private String province;
    private String city;
    private String referrals;
    private int product_count;
    private int like_count;
    private int down_count;

}
