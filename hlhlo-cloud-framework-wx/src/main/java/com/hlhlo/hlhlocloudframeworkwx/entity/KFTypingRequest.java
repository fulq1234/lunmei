package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 客服输入状态
 */
@Data
public class KFTypingRequest {
    @JsonIgnore
    private String accessToken;

    //普通用户（openid）
    private String touser;

    //"Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
    private String command;

}
