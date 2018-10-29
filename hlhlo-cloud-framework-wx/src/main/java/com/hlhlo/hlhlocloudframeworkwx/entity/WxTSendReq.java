package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxTSendReq {
    //接收者openid
    private String touser;

    //模板ID
    @JsonProperty("templateId")
    private String template_id;

    //模板跳转链接
    private String url;

    //跳小程序所需数据，不需跳小程序可不用传该数据
    @JsonProperty("miniprogram")
    private KFMsgMiniprogrampageInfoRequest miniprogram;

    //模板数据
    @JsonProperty("data")
    private WxTSendDataReq data;
}
