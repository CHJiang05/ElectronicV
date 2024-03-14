package com.example.electronicv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("user_vo")
public class UserVo {
    @ApiModelProperty(value = "ID", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "用户名", example = "zj")
    private String username;
    @ApiModelProperty(value = "用户名", example = "zj")
    private String phone;
    @ApiModelProperty(value = "商品", example = "zxc123")
    private String product;
    @ApiModelProperty(value = "标志", example = "zxc123")
    private String remarks;
    @ApiModelProperty(value = "地址", example = "zxc123")
    private String address;

}
