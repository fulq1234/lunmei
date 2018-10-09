package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

@Data
public class WxAccessToken {

    //获取到的凭证
    private String access_token;

    //凭证有效时间，单位：秒
    private Long expires_in;

    //错误码
    private Integer errcode;

    //错误信息
    private String errmsg;

}
