package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class KFMsgListResponse extends BaseResponse {
    @JsonProperty("recordlist")
    private List<KFMsgInfoResponse> param;
    private Integer number;
    private String msgid;
}
