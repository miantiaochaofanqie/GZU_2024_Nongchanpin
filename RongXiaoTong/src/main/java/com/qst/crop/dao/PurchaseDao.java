package com.qst.crop.dao;
import org.springframework.stereotype.Repository;
import com.qst.crop.entity.Purchase;
import com.qst.crop.model.MyPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Repository
public interface PurchaseDao {
    int insertSelective(Purchase record);
    Purchase selectNewPurchaseId(@Param("ownName")String ownName);
    List<MyPurchase> selectByPurchase(String name);
}