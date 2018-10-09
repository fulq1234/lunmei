package com.hlhlo.cloud.api.wxapp.model;

import lombok.Data;

import java.util.List;

/**
 * 微信的分页实体
 * @param <T>
 */

@Data
public class WxListBean<T> {
    //错误码
    private int errcode;

    //错误信息
    private String errmsg;

    //总数
    private Integer total_count;

    //列表
    private List<T> list;
}
