package com.journaldev.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Inventory;
import com.journaldev.spring.model.Sales;
import com.journaldev.spring.service.InventoryService;
import com.journaldev.spring.service.SalesService;

@Controller
public class InvoiceController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private InventoryService inventoryService;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired(required = true)
    @Qualifier(value = "salesService")
    public void setSalesService(SalesService ps) {
        this.salesService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "inventoryService")
    public void setInventoryService(InventoryService ps) {
        this.inventoryService = ps;
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public void createSales(HttpServletRequest request, Model model) {

        List<Sales> salesList = salesService.listSaless();
        List<Inventory> InvoiceList = inventoryService.listInventorys();
        Sales sales = salesList.get(0);
        // for (Sales sale : salesList) {
        for (Inventory inventory : InvoiceList) {
            // if (sale.getSaleNo().equals(inventory.getSerialNo())) {
            sales.getInventoryList().add(inventory);
            // }
        }
        // }
        model.addAttribute("SalesData", sales);

        logger.debug("Input Message PDF Viewer");

    }

}
