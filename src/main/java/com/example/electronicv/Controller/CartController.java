package com.example.electronicv.Controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.electronicv.Mapper.CartMapper;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.Cart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation("获取购物车")
    @CrossOrigin
    @RequestMapping(value="/display",method =RequestMethod.POST)
    public Result<?> display(@RequestBody Cart cart){
       List<Cart> res =cartMapper.selectList(Wrappers.lambdaQuery());
        return Result.success(res);
    }
}
