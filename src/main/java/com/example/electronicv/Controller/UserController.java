package com.example.electronicv.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.electronicv.LoginUser;
import com.example.electronicv.Mapper.UserMapper;
import com.example.electronicv.Utils.TokenUtils;
import com.example.electronicv.common.Result;
import com.example.electronicv.entity.MyModify;
import com.example.electronicv.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Result<?> register(@RequestBody User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));

        if (res != null) {
            return Result.error("-1", "用户名已重复");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String originalPassword = user.getPassword();

        String encodedPassword = passwordEncoder.encode(originalPassword);
        user.setPassword(encodedPassword);
        userMapper.insert(user);
        return Result.success();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {

        // 假设user是请求中传来的用户对象，包含登录时输入的用户名和密码
        User userFromDb = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, user.getUsername()));

// 检查是否找到了用户
        if (userFromDb == null) {
            return Result.error("-1", "用户名或密码错误");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
// 使用BCrypt进行密码匹配验证
        if (!passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            // 如果密码不匹配
            return Result.error("-1", "用户名或密码错误");
        }

// 如果用户名和密码都匹配，则生成Token
        String token = TokenUtils.genToken(userFromDb);
        userFromDb.setUsertoken(token);

// 可以增加用户访问计数
        LoginUser.addVisitCount();

// 返回包含用户信息和Token的成功响应
        return Result.success(userFromDb);

    }

    @ApiOperation("修改密码")
    @CrossOrigin
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Result<?> modify(@RequestBody MyModify modify)
    {
        User res =userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,modify.getUsername()));
        if(res==null)
        {
            return Result.error("-1","用户名不存在");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(modify.getPassword(), res.getPassword()))
        {
            return Result.error("-1","密码验证错误");
        }
        res.setPassword(passwordEncoder.encode(modify.getModify()));
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",modify.getUsername());
        userMapper.update(res,updateWrapper);
        return Result.success(res);
    }


    @ApiOperation("完善信息")
    @CrossOrigin
    @RequestMapping(value = "/improve",method = RequestMethod.POST)
    public Result<?> improve(@RequestBody User user)
    {
        User res=userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,user.getUsername()));
        if(res==null)
        {
            return Result.error("-1","出了点小意外呢");
        }
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",user.getUsername());
        res.setEmail(user.getEmail());
        res.setAddress(user.getAddress());
        userMapper.update(res,updateWrapper);
        return Result.success(res);
    }

}

