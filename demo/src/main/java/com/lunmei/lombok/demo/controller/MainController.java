package com.lunmei.lombok.demo.controller;

import com.lunmei.lombok.demo.entity.Projects;
import com.lunmei.lombok.demo.mapper.ProjectsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;

@Api(value="主入口Controller")
@Controller
@Slf4j
public class MainController {

    @Autowired
    private ProjectsMapper projectsMapper;

    @ResponseBody
    @RequestMapping("/a")
    @ApiOperation(value="根据id查询内容")
    public Projects queryById(@RequestParam(value="id") Long id){
        Projects k = projectsMapper.findOne(id);
        log.info("==========查看信息==========");
        return k;
    }

    @RequestMapping("/b")
    @ApiOperation(value="保存内Save")
    public void save(Projects k){

        log.info("==========保存信息==========");
        projectsMapper.save(k);
    }
}
