package com.hlhlo.cloud.api.wxapp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hlhlo.cloud.api.wxapp.model.*;
import com.hlhlo.cloud.api.wxapp.service.WxTemplateMinService;
import com.hlhlo.cloud.api.wxapp.util.WxInterfaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

//@Slf4j
@Service
public class WxTemplateMinServiceImpl implements WxTemplateMinService
{

   // @Qualifier("getCloseableHttpClient")
    private CloseableHttpClient httpClient;//统一注入

    @Value("${WX.APPID}")
    public String APPID;// = "wxe3122628b16b4386";

    @Value("${WX.APPSECRET}")
    public String APPSECRET;//  = "cc6957d8ae28da8ead9e44f53ac3b614";

    //获取小程序access_token
    public final String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //public String getAccessTokenUrl = "http://localhost:8088/a/hello";

    //调用 code2Session 接口，换取 用户唯一标识 OpenID 和 会话密钥 session_key。
    public final String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=APPSECRET&js_code=JSCODE&grant_type=authorization_code";

    //添加模板
    public final String addTemplateUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add?access_token=ACCESS_TOKEN";

    //删除模板
    public final String deleteTemplateUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/del?access_token=ACCESS_TOKEN";

    //获取模板库某个模板标题下关键词库
    public final String getTemplateLibraryByIdUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get?access_token=ACCESS_TOKEN";

    //获取小程序模板库标题列表
    public final String getTemplateLibraryListUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list?access_token=ACCESS_TOKEN";

    //获取帐号下已存在的模板列表
    private final String getTemplateListUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN";

    //发送模板信息
    private final String sendTemplateMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";


    public WxTemplateMinServiceImpl() {
        httpClient = HttpClientBuilder.create().build();//统一注入了，就不用单独创建了。
    }

    /**
     * 获得小程序的access_token
     * @return
     */
    @Override
    public Result<WxAccessToken> getAccessToken() {

        //请求地址
        String url = this.getAccessTokenUrl;
        url = url.replace("APPID",APPID);
        url = url.replace("APPSECRET",APPSECRET);

        //返回参数
        Result<WxAccessToken> result = WxInterfaceUtil.HandlePostMessageByGet(httpClient,url, WxAccessToken.class);
        return result;

    }

    /**
     * 登录凭证校验，通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录。
     * 步骤：
     * 1.调用 wx.login() 获取 临时登录凭证code ，并回传到开发者服务器。
     * 2.调用 code2Session 接口，换取 用户唯一标识 OpenID 和 会话密钥 session_key
     * @param jscode：登录时获取的 code
     * @return
     */
    public Result<WxCode2Session> getCode2Session(String jscode){
        //请求地址
        String url = this.code2SessionUrl;
        url = url.replace("APPID",APPID);
        url = url.replace("APPSECRET",APPSECRET);
        url = url.replace("JSCODE",jscode);
        //返回参数
        Result<WxCode2Session> result = WxInterfaceUtil.HandlePostMessageByPost(httpClient,url,null,WxCode2Session.class);
        return result;

    }
    /**
     * 添加模板,注意可以重复添加
     * @param ACCESS_TOKEN:接口调用凭证
     * @param id：模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @param keyword_id_list：开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如[3,5,4]或[4,5,3]），最多支持10个关键词组合
     */
    public Result<WxAddTemplate> addTemplate(String ACCESS_TOKEN, String id, Integer[] keyword_id_list){
        //请求地址
        String url = addTemplateUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        //参数
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",id);
        jsonObject.put("keyword_id_list",keyword_id_list);
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");

        Result<WxAddTemplate> str = WxInterfaceUtil.HandlePostMessageByPost(httpClient,url,entity,String.class);

        return str;

    }

    /**
     * 删除Template
     * @param ACCESS_TOKEN：接口调用凭证
     * @param template_id：要删除的模板id
     * @return
     */
    public Result<WxMessage> deleteTemplate(String ACCESS_TOKEN, String template_id){
        String url = this.deleteTemplateUrl;
        url = deleteTemplateUrl.replace("ACCESS_TOKEN",ACCESS_TOKEN);


        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id",template_id);
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
        Result<WxMessage> result = WxInterfaceUtil.HandlePostMessageByPost(httpClient,url,entity,WxMessage.class);
        return Result.buildSuccess();
    }

    /**
     *获取模板库某个模板标题下关键词库
     * @param ACCESS_TOKEN:接口调用凭证
     * @param id:模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @return
     */
    public Result<WxTemplateLib> getTemplateLibraryById(String ACCESS_TOKEN, String id){

        //请求地址
        String url = this.getTemplateLibraryByIdUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        //参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");

        //result：返回值
        Result<WxTemplateLib> result = WxInterfaceUtil.HandlePostMessageByPost(this.httpClient,url,entity, WxTemplateLib.class);

        return result;

    }

    /**
     * 获取小程序模板库标题列表
     * @param ACCESS_TOKEN：接口调用凭证
     * @param offset:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @return
     */
    public Result<WxListBean<WxTemplateLib>> getTemplateLibraryList(String ACCESS_TOKEN, int offset, int count){

        //请求地址
        String url = this.getTemplateLibraryListUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        //参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset",offset);
        jsonObject.put("count",count);
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");

        //result：返回值
        Result<WxListBean<WxTemplateLib>> result = WxInterfaceUtil.HandlePostMessageByPost(this.httpClient,url,entity, WxListBean.class);
        return result;
    }

    /**
     * 获取小程序模板库标题列表
     * @param ACCESS_TOKEN：接口调用凭证
     * @param offset:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count:offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @return
     */
    public Result<WxListBean<WxTemplate>> getTemplateList(String ACCESS_TOKEN, int offset, int count){

        //请求地址
        String url = this.getTemplateListUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        //参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset",offset);
        jsonObject.put("count",count);
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");

        //result：返回值
        Result<WxListBean<WxTemplate>> result = WxInterfaceUtil.HandlePostMessageByPost(this.httpClient,url,entity, WxListBean.class);


        return result;
    }


    /**
     * 发送模板消息
     * @param ACCESS_TOKEN:接口调用凭证
     * @param touser:接收者（用户）的 openid
     * @param template_id:所需下发的模板消息的id
     * @param page:点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     * @param form_id:表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     * @param data:模板内容，不填则下发空模板
     * @param emphasis_keyword:模板需要放大的关键词，不填则默认无放大
     * @return
     */
    public Result<WxAddTemplate> sendTemplateMessage(String ACCESS_TOKEN,
                                                     String touser,
                                                     String template_id,
                                                     String page,
                                                     String form_id,
                                                     Map<String,Map<String,String>> data, String emphasis_keyword){

        //请求地址
        String url = this.sendTemplateMessageUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        //参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser",touser);
        jsonObject.put("template_id",template_id);
        if(page != null){
            jsonObject.put("page",page);
        }
        if(form_id != null){
            jsonObject.put("form_id",form_id);
        }
        if(data != null){
            jsonObject.put("data",data);
        }

        if(emphasis_keyword != null){
            jsonObject.put("emphasis_keyword",emphasis_keyword);
        }

        System.out.println(jsonObject.toString());//打印测试语句

        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");

        Result<WxAddTemplate> result = WxInterfaceUtil.HandlePostMessageByPost(httpClient,url,entity,WxAddTemplate.class);

        return result;



    }
    public static void main(String args[]){
        WxTemplateMinServiceImpl templateMinService = new WxTemplateMinServiceImpl();

        //1.获取AccessToken
        Result<WxAccessToken> returnMsg = templateMinService.getAccessToken();
        if(!returnMsg.getSuccess()){
           //log.info("获取accesstoken失败");
           return;
        }
        WxAccessToken accessTokenIMessage = returnMsg.getData();
        String access_token = accessTokenIMessage.getAccess_token();

        //2.新增Template
        //templateMinService.addTemplate(access_token,"AT0009",new Integer[]{1,3,5});

        //3.删除Template
        templateMinService.deleteTemplate(access_token,"1yf45lp44jT0SL5J-lY80L8ghwtH4cgCuj1PGFfkbmw");

        //4.获取模板库某个模板标题下关键词库
        //Result<WxTemplateLib> result = templateMinService.getTemplateLibraryById(access_token,"00AT0009");


        //5.getTemplateLibraryList
        //Result<WxListBean<WxTemplateLib>> result = templateMinService.getTemplateLibraryList(access_token,0,20);

        //6.获取帐号下已存在的模板列表
        //Result<WxListBean<WxTemplate>> result6 = templateMinService.getTemplateList(access_token,0,20);

        //7.
        // touser,接收者（用户）的 openid
       /* String touser = "openid";
        //template_id,所需下发的模板消息的id
        String template_id = "AT0002";
        //page,点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
        String page = null;
        //form_id,表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
        String form_id = "12333";
        String data = "";//模板内容，不填则下发空模板
        String emphasis_keyword = null;
        templateMinService.sendTemplateMessage(access_token,touser,template_id,page,form_id,data,emphasis_keyword);*/
        System.out.println("===");
    }
}
