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

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据库字段")
@TableName("user")
public class Order {

    @ApiModelProperty(value = "订单ID", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer order_id;
    @ApiModelProperty(value = "订单时间", required = true, example = "0")
    private Time order_time;
    @ApiModelProperty(value = "订单状态", required = true, example = "已支付")
    private String pay_status;
    @ApiModelProperty(value = "配送状态", required = true, example = "正在配送")
    private String delivery_status;
    @ApiModelProperty(value = "订单价格", required = true, example = "520")
    private String price;
    @ApiModelProperty(value = "订单用户id", required = true, example = "1")
    private String order_user_id;

}
