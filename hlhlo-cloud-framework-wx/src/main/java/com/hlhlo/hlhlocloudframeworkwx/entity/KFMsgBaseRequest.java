package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 客服接口- 发信息
 */
@Data
public class KFMsgBaseRequest{
    @JsonIgnore
    private String accessToken;

    //普通用户openid
    private String touser;

    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype;//"text";

    //请注意，如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像），则需在JSON数据包的后半部分加入customservice参数，例如发送文本消息则改为：
    @JsonProperty("customservice")

    private KFMsgBaseInfoRequest kfMsgBaseInfoRequest;
}
