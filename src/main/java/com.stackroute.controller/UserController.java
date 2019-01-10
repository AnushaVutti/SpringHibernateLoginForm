package com.stackroute.controller;

import com.stackroute.dao.UserDao;
import com.stackroute.dao.UserDaoImpl;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    /*
     * Define a handler method to read the existing notes from the database and add
     * it to the ModelMap which is an implementation of Map, used when building
     * model data for use with views. it should map to the default URL i.e. "/index"
     */

    public UserController(UserDao userDao2) {
        // TODO Auto-generated constructor stub
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView submit() {
        return new ModelAndView("login", "User", new User());
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String showForm(ModelMap model, @RequestParam String userName, @RequestParam String password) {
//
//        model.addAttribute("userName", user.getUserName());
//        model.addAttribute("password", user.getPassword());
         User userdetails = new User();
         userdetails.setUserName(userName);
         userdetails.setPassword(password);

        if(userName.isEmpty() || password.isEmpty()){
            model.addAttribute("errorMessage", "No fields can be empty");
            return "index";
        } else {
            userDao.saveUser(userdetails);
            model.addAttribute("userList", userDao.getAllUsers());
            model.addAttribute("greeting","Welcome " + userdetails.getUserName() + " to stackroute");
            return "index";
        }
//        model.addAttribute("greeting","Welcome " + user.getUserName() + " to stackroute");
//        return "index";
    }

}
