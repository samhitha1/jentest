package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.InventoryDAO;
import com.journaldev.spring.model.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryDAO inventoryDAO;

    public void setInventoryDAO(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    @Transactional
    public void addInventory(Inventory p) {
        this.inventoryDAO.addInventory(p);
    }

    @Override
    @Transactional
    public void updateInventory(Inventory p) {
        this.inventoryDAO.updateInventory(p);
    }

    @Override
    @Transactional
    public List<Inventory> listInventorys() {
        return this.inventoryDAO.listInventorys();
    }

    @Override
    @Transactional
    public Inventory getInventoryById(int id) {
        return this.inventoryDAO.getInventoryById(id);
    }

    @Override
    @Transactional
    public void removeInventory(int id) {
        this.inventoryDAO.removeInventory(id);
    }
}
