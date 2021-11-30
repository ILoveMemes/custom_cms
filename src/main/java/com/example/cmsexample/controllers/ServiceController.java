package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController extends DaoControllerTemplate<Service> {

    @Autowired
    public ServiceController(DaoTemplate<Service> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "services/index";
    }

    @Override
    public String getInfoPage() {
        return "services/info";
    }

    @Override
    public Service dataInstanceBuilder() {
        return new Service();
    }
}
