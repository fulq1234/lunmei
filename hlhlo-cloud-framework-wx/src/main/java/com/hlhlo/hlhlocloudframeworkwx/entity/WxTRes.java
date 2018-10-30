package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 模板信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxTRes extends BaseResponse {

    //模板ID
    @JsonProperty("template_id")
    private String templateId;

    //模板标题
    @JsonProperty("title")
    private String title;

    //模板所属行业的一级行业
    @JsonProperty("primary_industry")
    private String primaryIndustry;

    //模板所属行业的二级行业
    @JsonProperty("deputy_industry")
    private String deputyIndustry;

    //模板内容
    @JsonProperty("content")
    private String content;

    //模板示例
    @JsonProperty("example")
    private String example;
}
