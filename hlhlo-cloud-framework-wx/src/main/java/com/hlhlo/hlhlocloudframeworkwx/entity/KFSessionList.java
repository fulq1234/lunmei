package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 获取客服会话列表实体
 */
@Data
public class KFSessionList extends BaseResponse{

    @JsonProperty("sessionlist")
    private List<KFSessionInfo> param;
}

