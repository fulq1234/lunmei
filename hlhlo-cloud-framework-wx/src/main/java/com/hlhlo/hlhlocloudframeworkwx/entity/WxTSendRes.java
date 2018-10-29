package com.hlhlo.hlhlocloudframeworkwx.entity;


import lombok.Data;

/**
 * 发送模板信息接收到的信息
 */
@Data
public class WxTSendRes extends BaseResponse {
    private String msgid;
}
