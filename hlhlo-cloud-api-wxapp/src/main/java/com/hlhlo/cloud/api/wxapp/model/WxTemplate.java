package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;


/**
 * 账号下已经存在的模板
 */
@Data
public class WxTemplate{
    //添加至帐号下的模板id，发送小程序模板消息时所需
    private String template_id;

    //模板标题
    private String title;

    //模板内容
    private String content;

    //模板内容示例
    private String example;
}
