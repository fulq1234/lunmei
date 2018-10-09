package com.hlhlo.cloud.api.wxapp.service;

import com.hlhlo.cloud.api.wxapp.model.*;

import java.util.Map;

/**
 * 微信小程序开发接口--模板信息
 */
public interface WxTemplateMinService {

    //获取小程序 access_token
    public Result<WxAccessToken> getAccessToken();

    /**
     * 登录凭证校验，通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录。
     * @param jscode：登录时获取的 code
     * @return
     */
    public Result<WxCode2Session> getCode2Session(String jscode);

    /**
     * 添加模板,注意可以重复添加
     * @param ACCESS_TOKEN:接口调用凭证
     * @param id：模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @param keyword_id_list：开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如[3,5,4]或[4,5,3]），最多支持10个关键词组合
     */
    public Result<WxAddTemplate> addTemplate(String ACCESS_TOKEN, String id, Integer[] keyword_id_list);

    /**
     * 删除Template
     * @param ACCESS_TOKEN：接口调用凭证
     * @param template_id：要删除的模板id
     * @return
     */
    public Result deleteTemplate(String ACCESS_TOKEN,String template_id);

    /**
     *获取模板库某个模板标题下关键词库
     * @param ACCESS_TOKEN:接口调用凭证
     * @param id:模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @return
     */
    public Result<WxTemplateLib> getTemplateLibraryById(String ACCESS_TOKEN, String id);

    /**
     * 获取小程序模板库标题列表
     * @param ACCESS_TOKEN：接口调用凭证
     * @param offset:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @return
     */
    public Result<WxListBean<WxTemplateLib>> getTemplateLibraryList(String ACCESS_TOKEN, int offset, int count);

    /**
     * 获取小程序模板库标题列表
     * @param ACCESS_TOKEN：接口调用凭证
     * @param offset:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @return
     */
    public Result<WxListBean<WxTemplate>> getTemplateList(String ACCESS_TOKEN, int offset, int count);

    /**
     * 发送模板消息
     * @param ACCESS_TOKEN:接口调用凭证
     * @param touser:接收者（用户）的 openid
     * @param template_id:所需下发的模板消息的id
     * @param page:点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     * @param form_id:表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     * @param data:模板内容，不填则下发空模板
     * @param emphasis_keyword:模板需要放大的关键词，不填则默认无放大,举例"keyword1.DATA"，放大的意思是字体变大
     * @return
     */
    public Result<WxAddTemplate> sendTemplateMessage(String ACCESS_TOKEN,
                                                     String touser,
                                                     String template_id,
                                                     String page,
                                                     String form_id,
                                                     Map<String,Map<String,String>> data, String emphasis_keyword);
}
