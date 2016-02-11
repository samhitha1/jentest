package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    private static final Logger logger = LoggerFactory.getLogger(InventoryDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addInventory(Inventory p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Inventory saved successfully, Inventory Details=" + p);
    }

    @Override
    public void updateInventory(Inventory p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Inventory updated successfully, Inventory Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Inventory> listInventorys() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Inventory> inventorysList = session.createQuery("from Inventory").list();
        for (Inventory p : inventorysList) {
            logger.info("Inventory List::" + p);
        }
        return inventorysList;
    }

    @Override
    public Inventory getInventoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Inventory p = (Inventory) session.load(Inventory.class, new Integer(id));
        logger.info("Inventory loaded successfully, Inventory details=" + p);
        return p;
    }

    @Override
    public void removeInventory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Inventory p = (Inventory) session.load(Inventory.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Inventory deleted successfully, inventory details=" + p);
    }

}
