package com.atguigu.liteims.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("product")
@Schema(name = "Product", description = "商品信息实体类") // 类级别描述
public class Product {

    @Schema(name = "id", title = "主键ID", description = "自动生成的商品唯一标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(name = "categoryId", title = "分类ID", description = "商品所属分类ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer isDeleted; //逻辑删除：0-正常，1-已删除
}

