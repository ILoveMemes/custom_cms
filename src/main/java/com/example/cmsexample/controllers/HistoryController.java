package com.example.cmsexample.controllers;

import com.example.cmsexample.common.DaoControllerTemplate;
import com.example.cmsexample.common.DaoTemplate;
import com.example.cmsexample.models.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController extends DaoControllerTemplate<History> {

    @Autowired
    public HistoryController(DaoTemplate<History> daoInstance, PictureController pictureController) {
        super(daoInstance, pictureController);
    }

    @Override
    public String getIndexPage() {
        return "history/index";
    }

    @Override
    public String getInfoPage() {
        return "history/info";
    }

    @Override
    public History dataInstanceBuilder() {
        return new History();
    }
}
