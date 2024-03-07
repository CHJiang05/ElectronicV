package com.example.electronicv.Controller;

import com.example.electronicv.Mapper.BizSellOrderMapper;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.BizSellOrder;
import com.example.electronicv.entity.Cart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "API接口")
@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BizSellOrderController {


    @Autowired
    @Resource
    private BizSellOrderMapper bizSellOrderMapper;

    @ApiOperation("提交购买")
    @CrossOrigin
    @RequestMapping(value="/commit",method = RequestMethod.POST)
    public Result<?> commit(@RequestBody List<BizSellOrder> bizSellOrder){
        for(int i=0;i<bizSellOrder.size();i++)
        {
            bizSellOrderMapper.insert(bizSellOrder.get(i));
        }
        return Result.success();
    }


}
