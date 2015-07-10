package com.decorpot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntroPageController extends DefaultController  {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String navigateToDashboard(final Model m) {
        
       m.addAttribute("title", "Test Funda");
        return navigateWithModels(m, "introPage", "introPage", "introPage");
    }


}



