package com.springboot.management.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {

    @ApiModelProperty("当前页")
    private Integer page;
    @ApiModelProperty("每页显示的条数")
    private Integer rows;
    @ApiModelProperty("排序的字段")
    private String sortBy;
    @ApiModelProperty("排序类型")
    private Boolean desc;
    @ApiModelProperty("用户名的模糊查询")
    private String key;
}
