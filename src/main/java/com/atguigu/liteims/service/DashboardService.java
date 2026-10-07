package com.atguigu.liteims.service;


import com.atguigu.liteims.vo.DashboardVO;

public interface DashboardService {

    /**
     * 仪表盘统计： 商品总数，今日订单，总销售额
     * @return
     */
    DashboardVO getStats();
}
