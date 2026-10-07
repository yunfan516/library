package com.atguigu.liteims.controller;

import com.atguigu.liteims.common.Result;
import com.atguigu.liteims.entity.Product;
import com.atguigu.liteims.service.ProductService;
import com.atguigu.liteims.vo.ProductVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "商品管理")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    @Operation(summary = "添加商品")
    public Result<Object> add(@RequestBody Product product) {
        return productService.save(product) ? Result.success(null) : Result.fail("添加失败");
    }

    @PutMapping
    @Operation(summary = "更新商品")
    public Result<Object> update(@RequestBody Product product) {
        return productService.updateById(product) ? Result.success(null) : Result.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除商品")
    public Result<Object> delete(@PathVariable Long id) {
        return productService.removeById(id) ? Result.success(null) : Result.fail("删除失败");
    }
}
