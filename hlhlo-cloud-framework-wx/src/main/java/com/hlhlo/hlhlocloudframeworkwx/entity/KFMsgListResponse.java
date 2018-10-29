package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public class KFMsgListResponse extends BaseResponse {
    @JsonProperty("recordlist")
    private List<KFMsgInfoResponse> param;
    private Integer number;
    private String msgid;
}
