package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 在线客服列表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class KFOnlineList extends BaseResponse{
    @JsonProperty("kf_online_list")
    private List<KFAccountResponse> list;
}
