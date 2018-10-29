package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxTIndustryInfo {
    @JsonProperty("first_class")
    private String firstClass;
    @JsonProperty("second_class")
    private String secondClass;
}
