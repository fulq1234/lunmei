package com.hlhlo.hlhlocloudframeworkwx.service.impl;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import com.hlhlo.hlhlocloudframeworkwx.utils.HttpUtils;
import com.hlhlo.hlhlocloudframeworkwx.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 客服信息：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140547
 */
@Service
@Slf4j
public class WxKFServiceImpl implements WxKFService {

    @Autowired
    private HttpUtils httpUtils;

    //获取AccessToken
    private static String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    //新增客服账号,http请求方式: POST
    private static String addKfaccountUrl = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=%s";

    //修改客服账号,http请求方式: POST
    private static String updateKfaccountUrl = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=%s";

    //删除客服账号,http请求方式: GET
    private static String delKfaccountUrl = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=%s";

    //设置客服账号的头像,http请求方式: POST/FORM
    private static String uploadHeadImgUrl = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=%s&kf_account=%s";

    //获取所有客服账号
    private static String getkflistUrl = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=%s";

    //获取所有在线客服账号
    private static String getonlineKfUrl = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=%s";

    //客服接口-发消息
    private static String sendMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";

    //客服输入状态
    private static String typingMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=%s";

    //邀请绑定客服账号
    private static String inviteworkerUrl = "https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=%s";

    //创建会话
    private static String createSessionUrl = "https://api.weixin.qq.com/customservice/kfsession/create?access_token=%s";

    //关闭会话
    private static String closeSessionUrl = "https://api.weixin.qq.com/customservice/kfsession/close?access_token=%s";

    //获取客户会话状态
    private static String getKfSessionUrl = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=%s&openid=%s";

    //获取客服会话列表
    private static String getSessionListUrl = "https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=%s&kf_account=%s";

    //获取未接入会话列表
    private static String getKfWaitCaseUrl = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=%s";

    //获得聊天记录
    private static String getMsgListUrl = "https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=%s";

    @Override
    public BaseAccessTokenResponse getAccessToken(String appId, String appSecret){
        //请求地址
        String url = String .format(getAccessTokenUrl,appId,appSecret);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取AccessToken】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseAccessTokenResponse response = JsonUtils.jsonToBean(respStr, BaseAccessTokenResponse.class);
        return response;
    }


    @Override
    public BaseResponse addAccount(KFAccountRequest account) {
        //请求地址
        String url = String.format(addKfaccountUrl,account.getAccessToken());

        String respStr = this.httpUtils.doPostJson(url,account);
        log.info("【微信公众号添加客服账号】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr, BaseResponse.class);
        return response;
    }

    @Override
    public BaseResponse updateAccount(KFAccountRequest account){
        //请求地址
        String url = String.format(updateKfaccountUrl,account.getAccessToken());

        String respStr = this.httpUtils.doPostJson(url,account);
        log.info("【微信公众号修改客服账号】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr, BaseResponse.class);
        return response;
    }

    @Override
    public BaseResponse delAccount(KFAccountRequest account){
        //请求地址
        String url = String.format(delKfaccountUrl,account.getAccessToken());

        String respStr = this.httpUtils.doPostJson(url,account);
        log.info("【微信公众号删除客服账号】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr, BaseResponse.class);
        return response;
    }

    /*
    * 上传客服头像
    *  调用示例（使用curl命令，用FORM表单方式上传一个多媒体文件）：
    *  curl -F media=@test.jpg "https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"
    *  media	form-data 中媒体文件标识，有filename、filelength、content-type 等信息，文件大小为5M 以内
     */
   @Override
    public BaseResponse uploadHeadImg(String accessToken, String kfAccount, String filePath){

        BaseResponse response = null;

        //请求地址
        String url = String.format(uploadHeadImgUrl,accessToken,kfAccount);

        //调用示例：使用curl命令，用FORM表单方式上传一个多媒体文件，curl命令的具体用法请自行了解
        //curl -F media=@test.jpg "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"
        String []cmds = {"curl", "-F", "media=@"+filePath, url};
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line=br.readLine())!=null){
                //System.out.println("\t"+line);
                if(line.contains("{") && line.contains("}")){//本行是带有返回的Json字符串的
                    response = JsonUtils.jsonToBean(line, BaseResponse.class);
                }
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public KFList getList(String accessToken){
        //请求地址
        String url = String.format(getkflistUrl,accessToken);

        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取公众号中所设置的客服基本信息】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFList response = JsonUtils.jsonToBean(respStr,KFList.class);
        return response;
    }

    @Override
    public KFOnlineList getonlineList(String accessToken){
        //请求地址
        String url = String.format(getonlineKfUrl,accessToken);

        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取公众号中所设置的客服基本信息】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFOnlineList response = JsonUtils.jsonToBean(respStr,KFOnlineList.class);
        return response;
    }

    @Override
    public BaseResponse sendMessage(KFMsgBaseRequest param){
        //请求地址
        String url = String.format(sendMessageUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众号客服发送信息】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return response;
    }

    @Override
    public BaseResponse messageTyping(KFTypingRequest param){

        //请求地址
        String url = String.format(typingMessageUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众号客服输入状态】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return response;

    }

    @Override
    public BaseResponse inviteworker(KFAccountRequest param){
        //请求地址
        String url = String.format(inviteworkerUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众号邀请绑定客服帐号】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return response;

    }

    @Override
    public BaseResponse createSession(KFAccountRequest param) {
        //请求地址
        String url = String.format(createSessionUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众号创建会话】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return response;
    }

    @Override
    public BaseResponse closeSession(KFAccountRequest param) {
        //请求地址
        String url = String.format(closeSessionUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众号关闭会话】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseResponse response = JsonUtils.jsonToBean(respStr,BaseResponse.class);
        return response;
    }

    @Override
    public KFAccountResponse getSession(String accessToken, String openid) {
        //请求地址
        String url = String.format(getKfSessionUrl,accessToken,openid);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取客户会话状态】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFAccountResponse response = JsonUtils.jsonToBean(respStr,KFAccountResponse.class);
        return response;
    }

    @Override
    public KFSessionList getSessionList(String accessToken, String kfAccount) {
        //请求地址
        String url = String.format(getKfSessionUrl,accessToken,kfAccount);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取客服会话列表】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFSessionList response = JsonUtils.jsonToBean(respStr,KFSessionList.class);
        return response;
    }

    @Override
    public KFWaitCase getWaitCase(String accessToken) {
        //请求地址
        String url = String.format(getKfWaitCaseUrl,accessToken);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取未接入会话列表】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFWaitCase response = JsonUtils.jsonToBean(respStr,KFWaitCase.class);
        return response;
    }

    @Override
    public KFMsgListResponse getMsgList(KFMsgListRequest param){
        //请求地址
        String url = String.format(closeSessionUrl,param.getAccessToken());
        String respStr = this.httpUtils.doPostJson(url,param);
        log.info("【微信公众获取聊天记录】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        KFMsgListResponse response = JsonUtils.jsonToBean(respStr,KFMsgListResponse.class);
        return response;
    }
}
