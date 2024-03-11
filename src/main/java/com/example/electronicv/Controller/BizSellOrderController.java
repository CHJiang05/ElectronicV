package com.example.electronicv.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.electronicv.Mapper.BizSellOrderMapper;
import com.example.electronicv.Mapper.BizSellOrderSubMapper;
import com.example.electronicv.Mapper.SystemCategoryMapper;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.*;
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
    @Autowired
    @Resource
    private BizSellOrderSubMapper bizSellOrderSubMapper;
    @Autowired
    @Resource
    private SystemCategoryMapper systemCategoryMapper;

    @ApiOperation("提交购买")
    @CrossOrigin
    @RequestMapping(value = "/commit", method = RequestMethod.POST)
    public Result<?> commit(@RequestBody List<BizSellOrder> bizSellOrders) {
        for (int i = 0; i < bizSellOrders.size(); i++) {
            bizSellOrderMapper.insert(bizSellOrders.get(i));
            Long id =bizSellOrders.get(i).getId();

        }

        return Result.success();
    }

    @ApiOperation("获取数据")
    @CrossOrigin
    @RequestMapping(value = "/commitsub", method = RequestMethod.POST)
    public Result<?> commitsub(@RequestBody List<String> name) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        QueryWrapper<BizSellOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id").last("LIMIT 1");
        BizSellOrder res = bizSellOrderMapper.selectOne(queryWrapper);
        Long time = res.getCtime();

        List<BizSellOrder> bizSellOrders = bizSellOrderMapper.selectList(Wrappers.<BizSellOrder>lambdaQuery().eq(BizSellOrder::getCtime, time).orderByAsc(BizSellOrder::getId));
        for (int i = 0; i < name.size(); i++) {

            UpdateWrapper<SystemCategory> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("name", name.get(i))
                    .setSql("ctime = ctime - 1");
            systemCategoryMapper.update(null, updateWrapper);
            BizSellOrderSub bizSellOrderSub = new BizSellOrderSub(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            bizSellOrderSub.setCname(name.get(i));
            bizSellOrderSub.setPid(bizSellOrders.get(i).getId().toString());
            QueryWrapper<SystemCategory> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("name", name.get(i));
            SystemCategory res2 = systemCategoryMapper.selectOne(queryWrapper1);
            bizSellOrderSub.setRemain_num(res2.getCtime());
            bizSellOrderSub.setPrice(res2.getLeaf());
            bizSellOrderSub.setCid(res2.getId());
            bizSellOrderSubMapper.insert(bizSellOrderSub);


        }

        return Result.success();
    }
    @ApiOperation("购买确认")
    @CrossOrigin
    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    public Result<?> confirm(@RequestBody MyRequest myRequest)
    {
        SystemCategory res=systemCategoryMapper.selectById(myRequest.getId());
        if(res==null)
        {
            return Result.error("-1","该商品已下架");
        }
        return Result.success(res);
    }

}
