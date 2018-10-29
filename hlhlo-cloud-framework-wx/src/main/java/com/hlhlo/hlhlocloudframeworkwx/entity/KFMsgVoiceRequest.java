package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hlhlo.hlhlocloudframeworkwx.enums.MsgTypeEnum;
import lombok.Data;

//发送语音消息
@Data
public class KFMsgVoiceRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.voice.getName();//"voice";

    @JsonProperty("voice")
    private KFMsgMediaRequest info;

}
