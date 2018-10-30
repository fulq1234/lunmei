package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseAccessTokenResponse extends BaseResponse {

    //获取到的凭证
    @JsonProperty("access_token")
    private String accessToken;

    //凭证有效时间，单位：秒
    @JsonProperty("expires_in")
    private String expiresIn;
}
