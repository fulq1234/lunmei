package com.hlhlo.hlhlocloudframeworkwx.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpUtils {
    @Autowired
    private CloseableHttpClient httpClient;

    public String doGet(String url){
        HttpGet get = new HttpGet(url);
        String respStr=this.doHttp(get);
        return respStr;
    }


    public String doPostForm(String url, Map<String, String> data) {
        String respStr = this.doPostForm(url, null, data);
        return respStr;
    }

    public String doPostForm(String url, Map<String, String> header, Map<String, String> data) {
        HttpPost post = new HttpPost(url);
        if (header != null) {
            header.forEach((name, value) -> post.addHeader(name, value));
        }
        List<NameValuePair> pairList = new ArrayList<>(data.size());
        for (Map.Entry<String, String> entry : data.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
            pairList.add(pair);
        }

        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(pairList, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        post.setEntity(entity);

        String respStr = this.doHttp(post);
        return respStr;
    }

    public <T> String doPostJson(String url, T data) {
        String respStr = this.doPostJson(url, null, data);
        return respStr;
    }

    public <T> String doPostJson(String url, Map<String, String> header, T data) {
        ContentType contentType = ContentType.APPLICATION_JSON;
        String respStr = this.doPostJson(url, contentType, header, data);
        return respStr;
    }

    public <T> String doPostJson(String url, ContentType contentType, Map<String, String> header, T data) {
        HttpPost post = new HttpPost(url);
        if (header != null) {
            header.forEach((name, value) -> post.addHeader(name, value));
        }

        if (contentType == null) {
            contentType = ContentType.APPLICATION_JSON;
        }

        String jsonString = JsonUtils.beanToJson(data);

        StringEntity entity = new StringEntity(jsonString, contentType);
        post.setEntity(entity);

        String respStr = this.doHttp(post);
        return respStr;
    }


    private String doHttp(HttpUriRequest request) {
        String respStr = null;
        // 发起请求
        CloseableHttpResponse response = null;
        try {
            response = this.httpClient.execute(request);
            HttpEntity responseEntity = response.getEntity();
            respStr = EntityUtils.toString(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return respStr;
    }
}
