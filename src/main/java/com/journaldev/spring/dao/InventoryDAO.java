package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Inventory;

public interface InventoryDAO {

    public void addInventory(Inventory p);

    public void updateInventory(Inventory p);

    public List<Inventory> listInventorys();

    public Inventory getInventoryById(int id);

    public void removeInventory(int id);
}
