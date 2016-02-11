package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Sales;

public interface SalesService {

    public void addSales(Sales p);

    public void updateSales(Sales p);

    public List<Sales> listSaless();

    public Sales getSalesById(int id);

    public void removeSales(int id);

}
