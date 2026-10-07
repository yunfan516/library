package com.atguigu.liteims.controller;

import com.atguigu.liteims.common.Result;
import com.atguigu.liteims.entity.Customer;
import com.atguigu.liteims.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "客户管理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @Operation(summary = "获取客户列表")
    public Result<List<Customer>> list() {
        return Result.success(customerService.list());
    }

    @PostMapping
    @Operation(summary = "添加客户")
    public Result<Object> add(@RequestBody Customer customer) {
        return customerService.save(customer) ? Result.success(null) : Result.fail("添加失败");
    }

    @PutMapping
    @Operation(summary = "更新客户")
    public Result<Object> update(@RequestBody Customer customer) {
        return customerService.updateById(customer) ? Result.success(null) : Result.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除客户")
    public Result<Object> delete(@PathVariable Long id) {
        return customerService.removeById(id) ? Result.success(null) : Result.fail("删除失败");
    }
}
