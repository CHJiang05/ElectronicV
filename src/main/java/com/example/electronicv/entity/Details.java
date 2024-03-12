package com.example.electronicv.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据库字段")
@TableName("details")
public class Details {
    @ApiModelProperty(value = "产品id", example = "1")
    private String id;
    @ApiModelProperty(value = "产品照片", example = "zxc123")
    private String url;

}
