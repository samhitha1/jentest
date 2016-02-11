package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Sales;

public interface SalesDAO {

    public void addSales(Sales p);

    public void updateSales(Sales p);

    public List<Sales> listSaless();

    public Sales getSalesById(int id);

    public void removeSales(int id);
}
