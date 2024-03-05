package com.example.electronicv.Controller;


import com.example.electronicv.Mapper.CartMapper;
import com.example.electronicv.Mapper.OrderMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "API接口")
@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    @Autowired
    @Resource
    private OrderMapper orderMapper;
}
