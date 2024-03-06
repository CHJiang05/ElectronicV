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
@TableName("cart")
public class Cart {
    @ApiModelProperty(value = "购物车ID", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "商品介绍", required = true, example = "1")
    private String date;
    @ApiModelProperty(value = "购物车图片", required = true, example = "1")
    private String imageurl;
    @ApiModelProperty(value = "购物加价格", required = true, example = "100")
    private Integer price;
    @ApiModelProperty(value = "购物车时间", required = true, example = "100")
    private String time;
    @ApiModelProperty(value = "商品名称", required = true, example = "100")
    private String name;

}
