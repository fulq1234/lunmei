package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;

public interface WxTService {

    /**
     * 设置所属行业
     * 设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业，具体如下：
     * @param accessToken
     * @param template
     * @return
     */
    public BaseResponse setIndustry(String accessToken, WxTSetReq template);

    /**
     * 获取设置的行业信息
     * 获取帐号设置的行业信息。可登录微信公众平台，在公众号后台中查看行业信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号所设置的行业信息
     * @param accessToken
     * @return
     */
    public WxTGetRes getIndustry(String accessToken);

    /**
     * 获得模板ID
     * 从行业模板库选择模板到帐号后台，获得模板ID的过程可在微信公众平台后台完成。为方便第三方开发者，提供通过接口调用的方式来获取模板ID，具体如下：
     * @param accessToken
     * @return
     */
    public WxTRes apiAddTemplate(String accessToken, WxTApiAddReq req);

    /**
     * 获取模板列表
     * 获取已添加至帐号下所有模板列表，可在微信公众平台后台中查看模板列表信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号下所有模板信息
     * @param accessToken
     * @return
     */
    public WxTList getAllPrivateTemplate(String accessToken);

    /**
     * 删除模板
     * 删除模板可在微信公众平台后台完成，为方便第三方开发者，提供通过接口调用的方式来删除某帐号下的模板
     * @param req
     * @return
     */
    public BaseResponse deleteTemplate(String accessToken, WxTApiAddReq req);

    /**
     * 发送模板消息
     * @param accessToken
     * @param req
     * @return
     */
    public WxTSendRes sendTtemplate(String accessToken, WxTSendReq req);
}
