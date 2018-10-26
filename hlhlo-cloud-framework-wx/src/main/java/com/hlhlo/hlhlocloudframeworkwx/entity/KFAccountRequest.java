package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 客服信息
 */
@Data
public class KFAccountRequest {

    @JsonIgnore
    private String accessToken;

    //完整客服帐号，格式为：帐号前缀@公众号微信号
    @JsonProperty("kf_account")
    private String kfAccount;

    //客服昵称，最长16个字
    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("password")
    private String password;

    //接收绑定邀请的客服微信号
    @JsonProperty("invite_wx")
    private String inviteWx;

    //粉丝的openid,用于“创建会话”用。
    @JsonProperty("openid")
    private String openid;
}
