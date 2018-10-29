package com.hlhlo.hlhlocloudframeworkwx.entity;


import lombok.Data;

@Data
public class KFMsgInfoResponse{
    //用户标识
    private String openid;
    //操作码，2002（客服发送信息），2003（客服接收消息）
    private String opercode;
    //聊天记录
    private String text;
    //操作时间，unix时间戳
    private String time;
    //完整客服帐号，格式为：帐号前缀@公众号微信号
    private String worker;
}
