package com.hlhlo.hlhlocloudframeworkwx.service.impl;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxTService;
import com.hlhlo.hlhlocloudframeworkwx.utils.HttpUtils;
import com.hlhlo.hlhlocloudframeworkwx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxTServiceImpl implements WxTService {

    @Autowired
    private HttpUtils httpUtils;

    //设置所属行业
    private static String setIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s";

    //获取设置的行业信息
    private static String getIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=%s";

    //获得模板ID
    private static String apiAddTUrl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s";

    //获取模板列表
    private static String getAllTListUrl = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=%s";

    //删除模板
    private static String delTUrl = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=%s";

    // 发送模板消息
    private static String sendTUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    @Override
    public BaseResponse setIndustry(String accessToken, WxTSetReq template) {
        String url = String.format(setIndustryUrl,accessToken);
        String respStr = httpUtils.doPostJson(url,template);
        BaseResponse a = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return a;
    }

    @Override
    public WxTGetRes getIndustry(String accessToken) {
        String url = String.format(getIndustryUrl,accessToken);
        String respStr = httpUtils.doGet(url);
        WxTGetRes a = JsonUtils.jsonToBean(respStr, WxTGetRes.class);
        return a;
    }

    @Override
    public WxTRes apiAddTemplate(String accessToken, WxTApiAddReq req) {
        String url = String.format(apiAddTUrl,accessToken);
        String respStr = httpUtils.doGet(url);
        WxTRes a = JsonUtils.jsonToBean(respStr, WxTRes.class);
        return a;
    }

    @Override
    public WxTList getAllPrivateTemplate(String accessToken) {
        String url = String.format(getAllTListUrl,accessToken);
        String respStr = httpUtils.doGet(url);
        WxTList a = JsonUtils.jsonToBean(respStr, WxTList.class);
        return a;
    }

    @Override
    public BaseResponse deleteTemplate(String accessToken, WxTApiAddReq req) {
        String url = String.format(delTUrl,accessToken);
        String respStr = httpUtils.doPostJson(url,req);
        BaseResponse a = JsonUtils.jsonToBean(respStr, BaseResponse.class);
        return a;
    }

    @Override
    public WxTSendRes sendTtemplate(String accessToken, WxTSendReq req) {
        String url = String.format(sendTUrl,accessToken);
        String respStr = httpUtils.doPostJson(url,req);
        WxTSendRes a = JsonUtils.jsonToBean(respStr, WxTSendRes.class);
        return a;
    }

}
