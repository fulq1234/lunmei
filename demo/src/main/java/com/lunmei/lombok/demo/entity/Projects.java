package com.lunmei.lombok.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 项目经验
 */
@Data
@ApiModel(value="项目经验")
public class Projects {
    private Long id;
    private Long resumeId;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//后台传到前台格式的转换。@JsonFormat会让时间以0区时间显示。如果直接使用会少了8小时（我所在的是北京时区）修改为
    @ApiModelProperty(value="开始时间")
    private Date startDate;

    @NotNull
    @ApiModelProperty(value="结束时间")
    private Date endDate;
    private String projectUrl;
    private String projectRole;
    private String projectExp;

    @NonNull //用于属性的非空检查，默认生成一个有参的构造函数
    @ApiModelProperty(value="项目名称")
    private String projectName;
}
