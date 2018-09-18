package com.lunmei.lombok.demo;

import com.lunmei.lombok.demo.entity.Projects;
import com.lunmei.lombok.demo.mapper.ProjectsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private ProjectsMapper projectsMapper;

    @Test
    public void contextLoads() {
        Projects projects = projectsMapper.findOne(1l);
        System.out.println(projects.toString());

    }

    @Test
    public void saveTest(){
        Projects projects = new Projects(new Date(),"ddd");
        projects.setResumeId(12l);
        projects.setProjectExp("项目完成了1");
        projects.setEndDate(new Date());
       // projects.setProjectName("ddd");
       // projects.setStartDate(new Date());
       // projects.setEndDate(new Date());
        projectsMapper.save(projects);
    }

}
