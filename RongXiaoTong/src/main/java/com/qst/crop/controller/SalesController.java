package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Sales;
import com.qst.crop.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author QST
 * @Description 销售模块
 * @Date 2021-08-24
 */
@Api(tags = "销售模块接口")
@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    // 查询销售汇总
    @ApiOperation(value = "查询销售汇总")
    @GetMapping("/summary")
    public Result<List<Sales>> getSalesSummary() {
        List<Sales> salesList = salesService.getSalesSummary();
        return new Result<>(true, StatusCode.OK, "查询成功", salesList);
    }
}
