package com.journaldev.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.journaldev.spring.model.Inventory;
import com.journaldev.spring.service.InventoryService;

@Controller
public class InventoryManagementController {

    InventoryService inventoryService;

    @Autowired(required = true)
    @Qualifier(value = "inventoryService")
    public void setInventoryService(InventoryService ps) {
        this.inventoryService = ps;
    }

    private static final Logger logger = LoggerFactory.getLogger(InventoryManagementController.class);

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/inventory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Inventory createInventory(@RequestBody Inventory inventory) {
        inventoryService.addInventory(inventory);

        logger.debug("Input Message", inventory.toString());
        return inventory;
    }

}
