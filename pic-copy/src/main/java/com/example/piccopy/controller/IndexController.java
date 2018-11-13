package com.example.piccopy.controller;

import com.example.piccopy.utils.Base64Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")

public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/umeditor")
    public String umeditor(){

        return "umeditor_index";
    }

    @RequestMapping("/kindeditor")
    public String kindeditor(){
        return "kindeditor_index";
    }

    /**
     * kindeditor，beforeSetHtml处理字符串内容
     * @param htmlStr
     * @return
     */

    @RequestMapping("/ke")
    @ResponseBody
    public String KEBeforeSet(String htmlStr){
        String html = Base64Utils.KEBeforeSet(htmlStr);
        return html;
    }
}
