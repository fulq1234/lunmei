package com.hlhlo.cloud.api.wxapp.controller;

import com.hlhlo.cloud.api.wxapp.model.Result;
import com.hlhlo.cloud.api.wxapp.model.WxAccessToken;
import com.hlhlo.cloud.api.wxapp.model.WxAddTemplate;
import com.hlhlo.cloud.api.wxapp.model.WxCode2Session;
import com.hlhlo.cloud.api.wxapp.service.WxTemplateMinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//@Slf4j
@Controller
@RequestMapping("/wt")
public class WxTemplateController {

    @Autowired
    private WxTemplateMinService wxTMS;


    /**
     * 登录凭证校验，通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。更多使用方法详见 小程序登录。
     * 可以得到openid,session_key,unionid
     * @param jscode：登录时获取的 code
     * @return
     */
    @RequestMapping("/code2session")
    @ResponseBody
    public Result<WxCode2Session> handleCode2Session(String jscode){
        Result<WxCode2Session> result = wxTMS.getCode2Session(jscode);
        String openid = "";
        if(result.getSuccess()){
            WxCode2Session data = result.getData();
            return Result.buildSuccess(data);
        }else{
            return Result.buildFailure("操作失败");
        }

    }

    /**
     * 发送模板信息
     * @param openid：用户唯一标识
     * @param formid：表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     * @return
     */
    @RequestMapping("/sendTM")
    @ResponseBody
    public String sendTemplateMessage(@RequestParam(name="openid") String openid, @RequestParam(name="formid")String formid){
        if(openid== null){
            return "openid is null";
        }
        //1.获取AccessToken
        Result<WxAccessToken> returnMsg = wxTMS.getAccessToken();
        if(!returnMsg.getSuccess()){
            return "error";
        }
        WxAccessToken accessTokenIMessage = returnMsg.getData();
        String access_token = accessTokenIMessage.getAccess_token();

        Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
        Map<String,String> keyword1 = new HashMap<String,String>();
        keyword1.put("value","Java后台开发工程师");//职位名称
        data.put("keyword1",keyword1);

        Map<String,String> keyword2 = new HashMap<String,String>();
        keyword2.put("value","阿里巴巴（中国）有限公司");//公司名称
        data.put("keyword2",keyword2);

        Result<WxAddTemplate> wxAddTemplateResult = wxTMS.sendTemplateMessage(
                access_token,
                openid,
                "PNCks3lNcdvMMg8JH-oa2FYyRvy7kWtOKXdoBOCEV_U",
                "www.baidu.com",
                formid,
                data,
                null);
        WxAddTemplate wxAddTemplate = wxAddTemplateResult.getData();
        System.out.println(wxAddTemplate.getErrcode() + "");
        System.out.println(wxAddTemplate.getErrmsg());
        System.out.println(wxAddTemplate.getTemplate_id());
        return "success";
    }
}
