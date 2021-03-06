package com.codecool.krk.javadatabasewebapp.controller;


import com.codecool.krk.javadatabasewebapp.dao.CustomerDAO;
import com.codecool.krk.javadatabasewebapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> theCustomers = customerDAO.getCustomers();
        theModel.addAttribute("customers", theCustomers);

        return "list-customer";
    }
}
