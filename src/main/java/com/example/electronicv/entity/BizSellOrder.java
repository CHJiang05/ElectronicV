package com.example.electronicv.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据库字段")
@TableName("biz_sell_order")
public class BizSellOrder {

    @ApiModelProperty(value = "商品介绍", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "购物车图片", required = true, example = "1")
    private Integer customer_id;
    @ApiModelProperty(value = "购物加价格", required = true, example = "100")
    private String customer_name;
    @ApiModelProperty(value = "购物车时间", required = true, example = "100")
    private Integer cid;
    @ApiModelProperty(value = "商品名称", required = true, example = "100")
    private String cname;
    @ApiModelProperty(value = "商品介绍", required = true, example = "1")
    private Long ctime;
    @ApiModelProperty(value = "购物车图片", required = true, example = "1")
    private Integer vid;
    @ApiModelProperty(value = "购物加价格", required = true, example = "100")
    private String vname;
    @ApiModelProperty(value = "购物车时间", required = true, example = "100")
    private Long vtime;
    @ApiModelProperty(value = "商品名称", required = true, example = "100")
    private Integer status;
    @ApiModelProperty(value = "购物车图片", required = true, example = "1")
    private Integer finish;
    @ApiModelProperty(value = "购物加价格", required = true, example = "100")
    private Long ftime;
    @ApiModelProperty(value = "购物车时间", required = true, example = "100")
    private BigDecimal total;
    @ApiModelProperty(value = "商品名称", required = true, example = "100")
    private String remark;


}
