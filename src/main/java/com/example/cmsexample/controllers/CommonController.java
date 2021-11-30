package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController extends DaoControllerTemplate<Common> {

    @Autowired
    public CommonController(DaoTemplate<Common> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "common/index";
    }

    @Override
    public String getInfoPage() {
        return "common/info";
    }

    @Override
    public Common dataInstanceBuilder() {
        return new Common();
    }
}
