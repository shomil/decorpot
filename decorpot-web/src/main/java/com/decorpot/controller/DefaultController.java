package com.decorpot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;


public abstract class DefaultController {
	
	private static Logger LOG = LoggerFactory
			.getLogger(DefaultController.class);

   public String navigateWithModels(final Model m, final String pageName, final String... pageScripts){
    	m.addAttribute("pageScripts", pageScripts);
        m.addAttribute("pageName", pageName);
        return "index";
    }
    
}

