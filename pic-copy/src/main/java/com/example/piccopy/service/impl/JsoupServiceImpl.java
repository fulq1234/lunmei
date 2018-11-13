package com.example.piccopy.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


@Service
public class JsoupServiceImpl {

    /**
     * 处理html，img下载到本地，src路径指向本地
     * @param html
     * @return
     */
    public String DownImgsToLocal(String html){
        Document doc = null;
        doc = Jsoup.parse(html);

        for(Element element :doc.select("img")){

        }

        html = doc.html();
        return html;
    }
}
