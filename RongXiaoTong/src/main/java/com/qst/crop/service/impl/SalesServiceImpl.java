package com.qst.crop.service.impl;

import com.qst.crop.dao.SalesDao;
import com.qst.crop.entity.Sales;
import com.qst.crop.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final Logger logger = LoggerFactory.getLogger(SalesServiceImpl.class);
    private final SalesDao salesDao;

    public SalesServiceImpl(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    @Override
    public List<Sales> getSalesSummary() {
        try {
            return salesDao.getSalesSummaryByApplication();
        } catch (Exception e) {
            logger.error("SalesService---->getSalesSummary(...) error: " + e.getMessage(), e);
            return null;
        }
    }
}
