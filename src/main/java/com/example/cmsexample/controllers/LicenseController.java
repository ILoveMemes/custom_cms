package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/licenses")
public class LicenseController extends DaoControllerTemplate<License> {

    @Autowired
    public LicenseController(DaoTemplate<License> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "licenses/index";
    }

    @Override
    public String getInfoPage() {
        return "licenses/info";
    }

    @Override
    public License dataInstanceBuilder() {
        return new License();
    }
}
