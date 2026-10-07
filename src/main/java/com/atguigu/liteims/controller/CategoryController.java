package com.atguigu.liteims.controller;

import com.atguigu.liteims.common.Result;
import com.atguigu.liteims.entity.Category;
import com.atguigu.liteims.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类模块")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Operation(summary = "列表查询")
    @GetMapping
    public Result list() {
        return Result.success(categoryService.list());
    }

    @Operation(summary = "新增")
    @PostMapping
    public Result save(@RequestBody Category category) {
        return categoryService.save(category) ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @Operation(summary = "修改")
    @PutMapping
    public Result update(@RequestBody Category category) {
        return categoryService.updateById(category) ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @Operation(summary = "逻辑删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return categoryService.removeById(id) ? Result.success("删除成功") : Result.fail("删除失败");
    }
}
