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
@TableName("user")
public class User {
    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "用户名", example = "zj")
    private String username;
    @ApiModelProperty(value = "用户密码", example = "zxc123")
    private String password;
    @ApiModelProperty(value = "邮箱",  example = "1806314796@qq.com")
    private String email;
    @ApiModelProperty(value = "电话号码",  example = "15928754682")
    private String phonenumber;
    @ApiModelProperty(value = "地址",  example = "pkingU")
    private String address;
    @ApiModelProperty(value = "令牌",  example = "NULL")
    @TableField(exist = false)
    private String usertoken;

}
