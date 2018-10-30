package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取客服会话列表实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class KFSessionList extends BaseResponse{

    @JsonProperty("sessionlist")
    private List<KFSessionInfo> param;
}

