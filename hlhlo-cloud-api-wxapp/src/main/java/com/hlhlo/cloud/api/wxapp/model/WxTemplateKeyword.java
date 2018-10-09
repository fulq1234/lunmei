package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

/**
 * 模板的关键字
 */
@Data
public class WxTemplateKeyword {

    //关键词 id，添加模板时需要
    private int keyword_id;

    //关键词内容
    private String name;

    //关键词内容对应的示例
    private String example;
}
