package com.example.electronicv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @ApiModelProperty(value = "id", example = "1")
    @TableId(type = IdType.AUTO)
    private String id;
    @ApiModelProperty(value = "产品照片", example = "zxc123")
    private String url;
    @ApiModelProperty(value = "产品id", example = "zxc123")
    private Integer pid;
}
