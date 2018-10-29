package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

//发送视频消息单个详情
@Data
public class KFMsgVideoInfoRequest{
    private String media_id;
    private String thumb_media_id;
    private String title;
    private String description;
}
