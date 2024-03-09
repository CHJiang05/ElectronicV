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

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据库字段")
@TableName("biz_sell_order_sub")
public class BizSellOrderSub {

    @ApiModelProperty(value = "销售订单子表", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "销售订单ID", required = true, example = "1")
    private String pid;
    @ApiModelProperty(value = "商品ID", required = true, example = "100")
    private Integer cid;
    @ApiModelProperty(value = "商品名称", required = true, example = "100")
    private String cname;
    @ApiModelProperty(value = "销售数量", required = true, example = "100")
    private BigDecimal num;
    @ApiModelProperty(value = "销售单价", required = true, example = "1")
    private Integer price;
    @ApiModelProperty(value = "商品库存数量", required = true, example = "1")
    private Long remain_num;
}
