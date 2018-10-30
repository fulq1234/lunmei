package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data

public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -6950332376406422335L;
    /**
     * 错误码
     */
    @JsonProperty("errcode")
    private Integer errCode;

    //错误信息

    @JsonProperty("errmsg")
    private String errMsg;
}
