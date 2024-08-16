package com.qst.crop.dao;

import com.qst.crop.entity.Sales;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesDao {
    // 方法与 XML 中的 <select> id 匹配
    List<Sales> getSalesSummaryByApplication();
}
