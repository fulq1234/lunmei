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

