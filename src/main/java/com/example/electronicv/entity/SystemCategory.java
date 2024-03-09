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
@TableName("system_category")
public class SystemCategory {
    @ApiModelProperty(value = "ID", required = true, example = "1")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "产品id", required = true, example = "1")
    private Integer pid;
    @ApiModelProperty(value = "产品名称", required = true, example = "1")
    private String name;
    @ApiModelProperty(value = "价格", required = true, example = "100")
    private Integer leaf;
    @ApiModelProperty(value = "库存", required = true, example = "100")
    private Long ctime;


}
