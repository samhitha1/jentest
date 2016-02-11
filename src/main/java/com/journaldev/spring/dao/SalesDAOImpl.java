package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Sales;

@Repository
public class SalesDAOImpl implements SalesDAO {

    private static final Logger logger = LoggerFactory.getLogger(SalesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addSales(Sales p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Sales saved successfully, Sales Details=" + p);
    }

    @Override
    public void updateSales(Sales p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Sales updated successfully, Sales Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Sales> listSaless() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Sales> salessList = session.createQuery("from Sales").list();
        for (Sales p : salessList) {
            logger.info("Sales List::" + p);
        }
        return salessList;
    }

    @Override
    public Sales getSalesById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Sales p = (Sales) session.load(Sales.class, new Integer(id));
        logger.info("Sales loaded successfully, Sales details=" + p);
        return p;
    }

    @Override
    public void removeSales(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Sales p = (Sales) session.load(Sales.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Sales deleted successfully, sales details=" + p);
    }

}
