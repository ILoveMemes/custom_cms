package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messengers")
public class MessengerController extends DaoControllerTemplate<Messenger> {

    @Autowired
    public MessengerController(DaoTemplate<Messenger> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "messengers/index";
    }

    @Override
    public String getInfoPage() {
        return "messengers/info";
    }

    @Override
    public Messenger dataInstanceBuilder() {
        return new Messenger();
    }
}
