package com.hlhlo.cloud.api.wxapp.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlhlo.cloud.api.wxapp.model.Result;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class WxInterfaceUtil {


    /**
     * 以Post方式微信开放接口请求信息
     * @param httpClient：访问微信的HttpClient
     * @param url：请求地址
     * @param entity：参数
     * @param valueType:返回值的Class类型
     * @return Result,返回值
     */
    public static <T> Result HandlePostMessageByPost(CloseableHttpClient httpClient,String url, HttpEntity entity,Class<T> valueType){
       /* String url = this.getTemplateLibraryByIdUrl;
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);*/
       // CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        Result result = null;//返回信息
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        HttpEntity entity = new StringEntity(jsonObject.toString(),"utf-8");*/
       if(entity != null){
           httpPost.setEntity(entity);
       }

        try {
            response = httpClient.execute(httpPost);

            //操作是否成功
            int statuscode = response.getStatusLine().getStatusCode();
            if(statuscode != 200){
                result = Result.buildFailure("微信通信操作失败,错误码是" + statuscode);
            }else{

                //发送成功后返回的信息
                HttpEntity entity1 = response.getEntity();
                String str = EntityUtils.toString(entity1);

                //解析返回的信息，如果错误码不是0，也是失败
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode node = objectMapper.readTree(str);
                int errcode = node.path("errcode").asInt();
                if(errcode != 0 ){//操作失败
                    result = Result.buildFailure(str);
                }else{//操作成功
                    //操作成功后，返回正确信息。
                    T obj = objectMapper.readValue(str, valueType);
                    result = Result.buildSuccess(obj);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            result = Result.buildFailure(e.getMessage());
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 以Get方式微信开放接口请求信息
     * @param httpClient：访问微信的HttpClient
     * @param url：请求地址
     * @param valueType:返回值的Class类型
     * @return Result,返回值
     */
    public static <T> Result HandlePostMessageByGet(CloseableHttpClient httpClient,String url,Class<T> valueType){

        Result result = null;//返回信息
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);


        try {
            response = httpClient.execute(httpGet);

            //操作是否成功
            int statuscode = response.getStatusLine().getStatusCode();
            if(statuscode != 200){
                result = Result.buildFailure("微信通信操作失败,错误码是" + statuscode);
            }else{

                //发送成功后返回的信息
                HttpEntity entity1 = response.getEntity();
                String str = EntityUtils.toString(entity1);

                //解析返回的信息，如果错误码不是0，也是失败
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode node = objectMapper.readTree(str);
                int errcode = node.path("errcode").asInt();
                if(errcode != 0 ){//操作失败
                    result = Result.buildFailure(str);
                }else{//操作成功
                    //操作成功后，返回正确信息。
                    T obj = objectMapper.readValue(str, valueType);
                    result = Result.buildSuccess(obj);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            result = Result.buildFailure(e.getMessage());
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
