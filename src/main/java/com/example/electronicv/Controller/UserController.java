package com.example.electronicv;


import com.example.electronicv.Service.UserService;
import com.example.electronicv.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("添加完整信息")
    @PostMapping("/insert")
    public String insert(@RequestBody User user) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
        return userService.insert(user.getUser_id(), user.getUser_name(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getAddress());
    }


    @ApiOperation("查询id对应的信息")
    @GetMapping("/findById/{user_id}")
    public User findById(@PathVariable int user_id) {
        return userService.findById(user_id);
    }

    @ApiOperation("更新信息")
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @ApiOperation("删除指定id的信息")
    @DeleteMapping("/delete/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        userService.delete(user_id);
    }

}

