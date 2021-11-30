package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phones")
public class PhoneController extends DaoControllerTemplate<Phone> {

    @Autowired
    public PhoneController(DaoTemplate<Phone> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "phones/index";
    }

    @Override
    public String getInfoPage() {
        return "phones/info";
    }

    @Override
    public Phone dataInstanceBuilder() {
        return new Phone();
    }
}
