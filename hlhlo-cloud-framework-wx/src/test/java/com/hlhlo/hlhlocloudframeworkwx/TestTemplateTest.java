package com.hlhlo.hlhlocloudframeworkwx;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import com.hlhlo.hlhlocloudframeworkwx.service.WxTService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTemplateTest {
    private String appId = "wxec40750a90b478e5";
    private String appSecret = "87eb940de1cd6a9f02258162b2ccf80d";
    private String accessToken = "15_NUKJkr7RKNOhIpDJKGETpj3Jego7IxEsQ6JeDAeKXSMnFrUthXREoivkLM1QSY8wQI59CG9CwqKQ3_O4KFjKx6zL_-fufX2mXK38QAKrO-ULfpPhbfu50C8ZZqMKGWhAGAZVL";
    @Autowired
    private WxKFService kf;

    @Autowired
    private WxTService wxTemplateService;

    @Test
    public void testSetIndustry(){
        //BaseAccessTokenResponse atResponse = kf.getAccessToken(appId,appSecret);
        WxTSetReq template = new WxTSetReq();
        template.setIndustry_id1("1");
        template.setIndustry_id2("4");
        Object object = wxTemplateService.setIndustry(this.accessToken,template);
        System.out.println(object.toString());
    }

    /**
     * 获取设置的行业信息
     */
    @Test
    public void testgetIndustry(){
        WxTGetRes a = wxTemplateService.getIndustry(this.accessToken);
        System.out.println(a.toString());
    }

    //获得模板ID
    @Test
    public void testapiAddTemplate(){
        WxTApiAddReq req = new WxTApiAddReq();
        req.setTemplateIdShort("TM00015");
        WxTRes a = wxTemplateService.apiAddTemplate(this.accessToken,req);
        System.out.println(a.getClass());
    }
    /**
     * o36WF0kwKQEOq9-l9bqAiM5Nqlf8
     * gh_5c56f02a0097
     */
    @Test
    public void sendT(){
        WxTSendReq req = new WxTSendReq();
        String openid = "o36WF0kwKQEOq9-l9bqAiM5Nqlf8";
        req.setTemplate_id("is9PoJNLvYHKLVsRx2ilWYEpbU3oSVmvaX0FtHyAtvM");
        req.setTouser(openid);
        req.setUrl("http://www.baidu.com");
        WxTSendDataReq ss = new WxTSendDataReq();
        WxTKeyWord kw = new WxTKeyWord();
        kw.setValue("我的吱吱");
        kw.setColor("#173177");
        ss.setKeyword1(kw);
        req.setData(ss);
        WxTSendRes template = wxTemplateService.sendTtemplate(accessToken, req);
        System.out.println(template.toString());
    }
}
