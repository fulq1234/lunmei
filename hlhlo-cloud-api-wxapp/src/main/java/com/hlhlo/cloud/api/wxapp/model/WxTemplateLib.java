package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

import java.util.List;

/**
 * 模板库中的模板
 */
@Data
public class WxTemplateLib {
    //错误码
    private Integer errcode;

    //错误信息
    private String errmsg;

    //模板标题 id
    private String id;

    //模板标题
    private String title;

    //关键词列表
    private List<WxTemplateKeyword> keyword_list;
}
