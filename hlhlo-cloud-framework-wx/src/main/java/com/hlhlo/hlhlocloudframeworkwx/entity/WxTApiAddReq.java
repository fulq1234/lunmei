package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxTApiAddReq {
    @JsonProperty("template_id_short")
    private String templateIdShort;
}
