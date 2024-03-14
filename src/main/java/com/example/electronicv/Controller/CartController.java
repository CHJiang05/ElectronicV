package com.example.electronicv.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.electronicv.Mapper.CartMapper;
import com.example.electronicv.Mapper.SystemCategoryMapper;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.Cart;
import com.example.electronicv.entity.MyRequest;
import com.example.electronicv.entity.SystemCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "API接口")
@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {

    @Autowired
    @Resource
    private CartMapper cartMapper;
    @Resource
    private SystemCategoryMapper systemCategoryMapper;

    @ApiOperation("获取购物车")
    @CrossOrigin
    @RequestMapping(value="/display",method =RequestMethod.POST)
    public Result<?> display(){
       List<Cart> res =cartMapper.selectList(null);
        return Result.success(res);
    }

    @ApiOperation("删除购物车")
    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public Result<?> delete(@RequestBody Cart cart){
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date",cart.getDate());
        cartMapper.delete(queryWrapper);
        return Result.success();
    }

    @ApiOperation("提交购买")
    @CrossOrigin
    @RequestMapping(value = "/purchase",method = RequestMethod.POST)
    public Result<?> purchase(@RequestBody List<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", cart.get(i).getName());
            cartMapper.delete(queryWrapper);
        }
        return Result.success();
    }

    @ApiOperation("加入购物车")
    @CrossOrigin
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> add(@RequestBody MyRequest myRequest)
    {
        SystemCategory systemCategory=systemCategoryMapper.selectById(myRequest.getId());
        Cart cart=new Cart(
                null,
                systemCategory.getName(),
                systemCategory.getUrl(),
                systemCategory.getLeaf(),
                myRequest.getTime(),
                null
        );
        cartMapper.insert(cart);
        return Result.success();
    }
}
