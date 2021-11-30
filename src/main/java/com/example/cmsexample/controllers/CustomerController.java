package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController extends DaoControllerTemplate<Customer> {

    @Autowired
    public CustomerController(DaoTemplate<Customer> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "customers/index";
    }

    @Override
    public String getInfoPage() {
        return "customers/info";
    }

    @Override
    public Customer dataInstanceBuilder() {
        return new Customer();
    }

}
