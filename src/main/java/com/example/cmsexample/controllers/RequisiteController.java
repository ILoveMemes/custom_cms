package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Requisite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requisites")
public class RequisiteController extends DaoControllerTemplate<Requisite> {

    @Autowired
    public RequisiteController(DaoTemplate<Requisite> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "requisites/index";
    }

    @Override
    public String getInfoPage() {
        return "requisites/info";
    }

    @Override
    public Requisite dataInstanceBuilder() {
        return new Requisite();
    }
}
