package com.hlhlo.hlhlocloudframeworkwx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 客服信息
 */
@Data
public class KFAccountResponse {
    //完整客服账号，格式为：账号前缀@公众号微信号
    @JsonProperty("kf_account")
    private String kfAccount;

    //客服昵称
    @JsonProperty("kf_nick")
    private String kfNick;

    //客服工号
    @JsonProperty("kf_id")
    private String kfId;

    //客服头像
    @JsonProperty("kf_headimgurl")
    private String kfHeadimgurl;

    //如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
    @JsonProperty("kf_wx")
    private String KfWx;

    //如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
    @JsonProperty("invite_wx")
    private String inviteWx;

    //如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
    @JsonProperty("invite_expire_time")
    private String inviteExpireTime;

    //邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
    @JsonProperty("invite_status")
    private String inviteStatus;

    //客服在线状态，目前为：1、web 在线
    @JsonProperty("status")
    private Integer status;

    //客服当前正在接待的会话数
    @JsonProperty("accepted_case")
    private Integer acceptedCase;

    //会话接入的时间
    @JsonProperty("createtime")
    private Integer createtime;
}
