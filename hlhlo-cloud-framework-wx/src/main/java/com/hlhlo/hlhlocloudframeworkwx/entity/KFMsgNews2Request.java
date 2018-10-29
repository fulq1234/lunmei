package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KFMsgNews2Request{

    @JsonProperty("articles")
    private KFMsgNewsInfoRequest articles;
}
