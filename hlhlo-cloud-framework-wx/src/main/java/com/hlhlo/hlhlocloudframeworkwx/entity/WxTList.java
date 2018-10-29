package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WxTList {

    @JsonProperty("template_list")
    private List<WxTRes> list;
}
