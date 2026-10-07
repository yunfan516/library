package com.atguigu.liteims.controller;

import com.atguigu.liteims.common.Result;
import com.atguigu.liteims.service.DashboardService;
import com.atguigu.liteims.vo.DashboardVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "获取统计数据-仪表盘")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/stats")
    public Result getStats(){
        return Result.success(dashboardService.getStats());
    }
}
