package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

@Data
public class WxAddTemplate {

    //错误码
    private int errcode;

    //错误信息
    private String errmsg;

    //添加至帐号下的模板id，发送小程序模板消息时所需
    private String template_id;
}
