package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.SalesDAO;
import com.journaldev.spring.model.Sales;

@Service
public class SalesServiceImpl implements SalesService {

    private SalesDAO salesDAO;

    public void setSalesDAO(SalesDAO salesDAO) {
        this.salesDAO = salesDAO;
    }

    @Override
    @Transactional
    public void addSales(Sales p) {
        this.salesDAO.addSales(p);
    }

    @Override
    @Transactional
    public void updateSales(Sales p) {
        this.salesDAO.updateSales(p);
    }

    @Override
    @Transactional
    public List<Sales> listSaless() {
        return this.salesDAO.listSaless();
    }

    @Override
    @Transactional
    public Sales getSalesById(int id) {
        return this.salesDAO.getSalesById(id);
    }

    @Override
    @Transactional
    public void removeSales(int id) {
        this.salesDAO.removeSales(id);
    }
}
