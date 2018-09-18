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

@Api(value="主入口Controller")
@Controller
public class MainController {

    @Autowired
    private ProjectsMapper projectsMapper;

    @ResponseBody
    @RequestMapping("/a")
    @ApiOperation(value="根据id查询内容")
    public Projects queryById(@RequestParam(value="id") Long id){
        Projects k = projectsMapper.findOne(id);
        return k;
    }

    @RequestMapping("/b")
    @ApiOperation(value="保存内Save")
    public void save(Projects k){
        projectsMapper.save(k);
    }
}
