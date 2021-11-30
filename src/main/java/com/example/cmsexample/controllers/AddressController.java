package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addresses")
public class AddressController extends DaoControllerTemplate<Address> {

    @Autowired
    public AddressController(DaoTemplate<Address> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "addresses/index";
    }

    @Override
    public String getInfoPage() {
        return "addresses/info";
    }

    @Override
    public Address dataInstanceBuilder() {
        return new Address();
    }
}
