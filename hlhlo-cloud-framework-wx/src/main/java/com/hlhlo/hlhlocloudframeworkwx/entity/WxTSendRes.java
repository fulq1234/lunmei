package com.hlhlo.hlhlocloudframeworkwx.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 发送模板信息接收到的信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxTSendRes extends BaseResponse {
    private String msgid;
}
