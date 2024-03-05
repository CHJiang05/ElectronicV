package com.example.electronicv.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.electronicv.LoginUser;
import com.example.electronicv.Mapper.UserMapper;
import com.example.electronicv.Utils.TokenUtils;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "API接口")
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)

public class UserController {
    @Autowired

    @Resource
    private UserMapper userMapper;


    @ApiOperation("注册")
    @CrossOrigin
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,user.getUsername()));

        if(res.getPassword().isEmpty())
        {
            return Result.error("-1","用户名已重复");
        }
        userMapper.insert(user);
        return Result.success();
    }
    @CrossOrigin
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword()));
        if(res.getUsername().isEmpty())
        {
            return Result.error("-1","用户名或密码错误");
        }
        String token = TokenUtils.genToken(res);
        res.setUsertoken(token);
        LoginUser.addVisitCount();
        return Result.success(res);
    }

}

