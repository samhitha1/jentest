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

import com.journaldev.spring.model.Sales;
import com.journaldev.spring.service.SalesService;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired(required = true)
    @Qualifier(value = "salesService")
    public void setSalesService(SalesService ps) {
        this.salesService = ps;
    }

    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/sales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Sales createSales(@RequestBody Sales sales) {
        salesService.addSales(sales);

        logger.debug("Input Message", sales.toString());
        return sales;
    }

}
