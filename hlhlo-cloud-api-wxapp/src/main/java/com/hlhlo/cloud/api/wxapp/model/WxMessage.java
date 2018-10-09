package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

@Data
public class WxMessage {

    //错误码
    private Integer errcode;

    //错误信息
    private String errmsg;
}
