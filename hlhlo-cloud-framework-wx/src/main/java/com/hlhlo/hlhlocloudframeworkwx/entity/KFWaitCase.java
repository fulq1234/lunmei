package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 未接入会话列表
 */
@Data
public class KFWaitCase {

    //未接入会话数量
    private int count;

    //未接入会话列表，最多返回100条数据，按照来访顺序
    @JsonProperty("waitcaselist")
    private List<KFWaitCaseInfo> param;
}

@Data
class KFWaitCaseInfo{

    //粉丝的最后一条消息的时间
    @JsonProperty("latest_time")
    private Long latestTime;

    //粉丝的openid
    private String openid;
}
