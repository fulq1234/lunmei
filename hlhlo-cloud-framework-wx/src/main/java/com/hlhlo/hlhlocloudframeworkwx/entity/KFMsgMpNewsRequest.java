package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hlhlo.hlhlocloudframeworkwx.enums.MsgTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

//发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
@Data
@EqualsAndHashCode(callSuper = true)
public class KFMsgMpNewsRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.mpnews.getName();//"mpnews";
    @JsonProperty("mpnews")
    private KFMsgMediaRequest mpnews;

}
