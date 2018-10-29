package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

@Data
public class WxTSendDataReq {
    private WxTKeyWord first;
    private WxTKeyWord keyword1;
    private WxTKeyWord keyword2;
    private WxTKeyWord keyword3;
    private WxTKeyWord remark;
}
