package com.springboot.management.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户模型")
public class User {
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户密码")
    private String pwd;
}
