package com.searchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        System.out.println("thi is home");
        return "index";
    }

    //fetch data from form page and redirect to google
    @RequestMapping("/search")
    public RedirectView search(@RequestParam("data") String data) {

        if (data.isBlank()) {
            return new RedirectView("home");
        }

        String url = "https://www.google.com/search?q=" + data;

        RedirectView redirectView = new RedirectView(url);

        return redirectView;
    }
}
