package com.stackroute.controller;

import com.stackroute.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView submit() {
        return new ModelAndView("login", "User", new User());
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String showForm(ModelMap model, @ModelAttribute("login") User user) {
//
//        model.addAttribute("userName", user.getUserName());
//        model.addAttribute("password", user.getPassword());
        model.addAttribute("greeting","Welcome " + user.getUserName() + " to stackroute");
        return "index";
    }
//@RequestMapping(value = "/")
//public String greeting(ModelMap map){
//    map.addAttribute("greeting","Welcome to stackroute");
//    return "index";
//}

}
