package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hlhlo.hlhlocloudframeworkwx.enums.MsgTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

//发送小程序卡片（要求小程序与公众号已关联）
@Data
@EqualsAndHashCode(callSuper = true)
public class KFMsgMiniprogrampageRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.miniprogrampage.getName();//"miniprogrampage";
    @JsonProperty("miniprogrampage")
    private KFMsgMiniprogrampageInfoRequest info;
}
