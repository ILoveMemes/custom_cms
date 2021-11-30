package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partners")
public class PartnerController extends DaoControllerTemplate<Partner> {

    @Autowired
    public PartnerController(DaoTemplate<Partner> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "partners/index";
    }

    @Override
    public String getInfoPage() {
        return "partners/info";
    }

    @Override
    public Partner dataInstanceBuilder() {
        return new Partner();
    }
}
