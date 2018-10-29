package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 获取设置的行业信息模板
 */
@Data
public class WxTGetRes {
    //帐号设置的主营行业
    @JsonProperty("primary_industry")
    private WxTIndustryInfo primaryIndustry;

    //帐号设置的副营行业
    @JsonProperty("secondary_industry")
    private WxTIndustryInfo secondaryIndustry;
}
