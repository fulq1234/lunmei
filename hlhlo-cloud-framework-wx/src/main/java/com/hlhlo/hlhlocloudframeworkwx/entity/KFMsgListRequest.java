package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import java.util.List;

/**
 * 获取聊天记录
 */
@Data
public class KFMsgListRequest {

    @JsonIgnore
    private String accessToken;

    //起始时间，unix时间戳
    private Long starttime;
    //结束时间，unix时间戳，每次查询时段不能超过24小时
    private Long endtime;
    //消息id顺序从小到大，从1开始
    private Integer msgid;
    //每次获取条数，最多10000条
    private Integer number;
}
