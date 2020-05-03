package com.springboot.management.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ApiModelProperty("接收模糊查询得参数")
    private Map<Object,Object> key=new HashMap<>();

}
