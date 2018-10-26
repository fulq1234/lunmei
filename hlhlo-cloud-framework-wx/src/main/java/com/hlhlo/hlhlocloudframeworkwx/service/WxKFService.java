package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;

public interface WxKFService {

    /**
     * 获取access_token
     * @param appId：第三方用户唯一凭证
     * @param appSecret：第三方用户唯一凭证密钥，即appsecret
     * @return
     */
    public BaseAccessTokenResponse getAccessToken(String appId, String appSecret);

    /**
     * 添加客服帐号
     * @param account
     * @return
     */
    public BaseResponse addAccount(KFAccountRequest account);

    /**
     * 修改客服账号
     * @param account
     * @return
     */
    public BaseResponse updateAccount(KFAccountRequest account);

    /**
     * 删除客服帐号
     * @param account
     * @return
     */
    public BaseResponse delAccount(KFAccountRequest account);

    /**
     * 设置客服帐号的头像
     * @param accessToken:调用接口凭证
     * @param kfAccount:完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param filePath:头像的文件路径,头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * @return
     */
    public BaseResponse uploadHeadImg(String accessToken, String kfAccount, String filePath);

    /**
     * 开发者通过本接口，获取公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号。
     * @param accessToken:调用接口凭证
     * @return
     */
    public KFList getList(String accessToken);

    /**
     * 得到在线客服列表
     * @param accessToken
     * @return
     */
    public KFOnlineList getonlineList(String accessToken);
    /**
     * 客服接口-发消息
     * @param param
     * @return
     */
    public BaseResponse sendMessage(KFMsgBaseRequest param);

    /**
     * 客服输入状态
     * 此接口需要客服消息接口权限。     *
     *     如果不满足发送客服消息的触发条件，则无法下发输入状态。     *
     *     下发输入状态，需要客服之前30秒内跟用户有过消息交互。     *
     *     在输入状态中（持续15s），不可重复下发输入态。     *
     *     在输入状态中，如果向用户下发消息，会同时取消输入状态。
     * @param param
     * @return
     */
    public BaseResponse messageTyping(KFTypingRequest param);

    /**
     * 邀请绑定客服帐号
     * 新添加的客服帐号是不能直接使用的，只有客服人员用微信号绑定了客服账号后，方可登录Web客服进行操作。此接口发起一个绑定邀请到客服人员微信号，客服人员需要在微信客户端上用该微信号确认后帐号才可用。尚未绑定微信号的帐号可以进行绑定邀请操作，邀请未失效时不能对该帐号进行再次绑定微信号邀请。
     * @param param
     * @return
     */
    public BaseResponse inviteworker(KFAccountRequest param);

    /**
     * 会话控制
     * 创建会话
     * 此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线。
     * @param param
     * @return
     */
    public BaseResponse createSession(KFAccountRequest param);

    /**
     * 会话控制
     * 关闭会话
     * @param param
     * @return
     */
    public BaseResponse closeSession(KFAccountRequest param);

    /**
     * 获取客户会话状态
     * 此接口获取一个客户的会话，如果不存在，则kf_account为空。
     * @param accessToken:调用接口凭证
     * @param openid:粉丝的openid
     * @return
     */
    public KFAccountResponse getSession(String accessToken,String openid);

    /**
     * 获取客服会话列表
     * @param accessToken:调用接口凭证
     * @param kfAccount:完整客服帐号，格式为：帐号前缀@公众号微信号
     * @return
     */
    public KFSessionList getSessionList(String accessToken,String kfAccount);

    /**
     * 获取未接入会话列表
     * @param accessToken:调用接口凭证
     * @return
     */
    public KFWaitCase getWaitCase(String accessToken);

    /**
     * 获取聊天记录
     * 此接口返回的聊天记录中，对于图片、语音、视频，分别展示成文本格式的[image]、[voice]、[video]。对于较可能包含重要信息的图片消息，后续将提供图片拉取URL，近期将上线。
     * @param param
     * @return
     */
    public KFMsgListResponse getMsgList(KFMsgListRequest param);
}
