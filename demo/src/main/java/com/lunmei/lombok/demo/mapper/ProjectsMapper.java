package com.lunmei.lombok.demo.mapper;

import com.lunmei.lombok.demo.entity.Projects;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectsMapper {
    @Insert(value = "insert into projects (id,resumeId,projectName,startDate,endDate,projectUrl,projectRole,projectExp) " +
            "values(#{id},#{resumeId},#{projectName},#{startDate},#{endDate},#{projectUrl},#{projectRole},#{projectExp})")
    //@Options(useGeneratedKeys = true)
    int save(Projects projects);

    /*@UpdateProvider(type = ProjectsSqlProvider.class, method = "update")
    int update(Projects projects);*/

    @Delete(value = "delete from projects where id = #{id}")
    int delete(Long id);

    @Select(value = "select id, resumeId, projectName, startDate, endDate, projectUrl, projectRole, projectExp from projects where id = #{id}")
    Projects findOne(Long id);

    @Select(value = "select id,projectName,startDate,endDate,projectRole,projectExp from projects where resumeId = #{resumeId}")
    List<Projects> findList(Long resumeId);
}
