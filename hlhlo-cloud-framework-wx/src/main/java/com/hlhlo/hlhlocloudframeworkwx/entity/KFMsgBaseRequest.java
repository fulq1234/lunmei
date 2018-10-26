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

@Data
class KFMsgBaseInfoRequest{
    private String kf_account;
}



//文本消息
@Data
class KFMsgTextRequest2  extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
   private String msgtype = MsgTypeEnum.text.getName();//"text";
    @JsonProperty("text")
    private KFMsgTextInfoRequest info;
}


@Data
class KFMsgTextInfoRequest{
    //文本消息内容
    private String content;
}

//发送图片消息
@Data
class KFMsgImageRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.image.getName();//"image";
    @JsonProperty("image")
    private KFMsgMediaRequest info;
}

@Data
class KFMsgMediaRequest{
    private String media_id;
}

//发送语音消息
@Data
class KFMsgVoiceRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.voice.getName();//"voice";

    @JsonProperty("voice")
    private KFMsgMediaRequest info;

}

//发送视频消息
@Data
class KFMsgVideoRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.video.getName();//"video";
    @JsonProperty("video")
    private KFMsgVideoInfoRequest info;
}

//发送视频消息单个详情
@Data
class KFMsgVideoInfoRequest{
    private String media_id;
    private String thumb_media_id;
    private String title;
    private String description;
}

//发送音乐消息
@Data
class KFMsgMusicRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.music.getName();//"music";
    @JsonProperty("music")
    private KFMsgMusicInfoRequest info;
}

@Data
class KFMsgMusicInfoRequest{
    private String title;
    private String description;
    private String musicurl;
    private String hqmusicurl;
    private String thumb_media_id;

}

//发送图文消息（点击跳转到外链） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
@Data
class KFMsgNewsRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.news.getName();//"news";

    @JsonProperty("news")
    private KFMsgNews2Request info;
}

@Data
class KFMsgNews2Request{

    @JsonProperty("articles")
    private KFMsgNewsInfoRequest articles;
}

@Data
class KFMsgNewsInfoRequest{
    private String title;
    private String description;
    private String url;
    private String picurl;
}

//发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
@Data
class KFMsgMpNewsRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.mpnews.getName();//"mpnews";
    @JsonProperty("mpnews")
    private KFMsgMediaRequest mpnews;

}

//发送卡券
@Data
class KFMsgWxcardRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.wxcard.getName();//"wxcard";
    @JsonProperty("wxcard")
    private KFMsgWxcardInfoRequest wxcard;

}

@Data
class KFMsgWxcardInfoRequest{
    private String card_id;
}

//发送小程序卡片（要求小程序与公众号已关联）
@Data
class KFMsgMiniprogrampageRequest extends KFMsgBaseRequest{
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
    private String msgtype = MsgTypeEnum.miniprogrampage.getName();//"miniprogrampage";
    @JsonProperty("miniprogrampage")
    private KFMsgMiniprogrampageInfoRequest info;
}

@Data
class KFMsgMiniprogrampageInfoRequest{
    private String title;
    private String appid;
    private String pagepath;
    private String thumb_media_id;
}