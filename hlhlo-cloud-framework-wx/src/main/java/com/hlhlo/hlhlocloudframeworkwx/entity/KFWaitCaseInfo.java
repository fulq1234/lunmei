package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KFWaitCaseInfo{

    //粉丝的最后一条消息的时间
    @JsonProperty("latest_time")
    private Long latestTime;

    //粉丝的openid
    private String openid;
}