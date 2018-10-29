package com.hlhlo.hlhlocloudframeworkwx.entity;

import lombok.Data;

/**
 * 微信模板消息设置行业
 */
@Data
public class WxTSetReq {

    //公众号模板消息所属行业编号
    private String industry_id1;
    //公众号模板消息所属行业编号
    private String industry_id2;
}
