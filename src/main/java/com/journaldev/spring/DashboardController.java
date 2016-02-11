package com.journaldev.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Small controller that gets the user to the dashboard
 */
@Controller
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    /**
     * Hook to get the base url
     */

    /**
     * Redirects user to the index page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = { "/", "/orderManagement" })
    public String defaultPage(final Model model) {
        // model.addAttribute("user", user.getFullName());
        // model.addAttribute("baseUrl", this.dashboardService.getBaseUrl());

        return "/main";
    }

}
