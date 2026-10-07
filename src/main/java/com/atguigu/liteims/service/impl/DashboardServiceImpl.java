package com.atguigu.liteims.service.impl;

import com.atguigu.liteims.entity.SaleOrder;
import com.atguigu.liteims.mapper.ProductMapper;
import com.atguigu.liteims.mapper.SaleOrderMapper;
import com.atguigu.liteims.service.DashboardService;
import com.atguigu.liteims.vo.DashboardVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.bytebuddy.asm.Advice;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    SaleOrderMapper saleOrderMapper;

    @Override
    public DashboardVO getStats() {
        DashboardVO dashboardVO = new DashboardVO();

        //获取商品总数
        Long productCount = productMapper.selectCount(null);
        dashboardVO.setProductCount(productCount);

        //获取今日订单数量
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LambdaQueryWrapper<SaleOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(SaleOrder::getCreateTime,start,end);
        Long todayOrderCount = saleOrderMapper.selectCount(queryWrapper);
        dashboardVO.setTodayOrderCount(todayOrderCount);

        //总销售额
        BigDecimal totalSales = saleOrderMapper.getTotalSales();
        dashboardVO.setTotalSales(totalSales);

        return dashboardVO;
    }
}
