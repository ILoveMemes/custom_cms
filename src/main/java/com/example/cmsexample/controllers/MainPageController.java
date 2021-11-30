package com.example.cmsexample.controllers;

import com.example.cmsexample.models.Picture;
import com.example.cmsexample.common.DaoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.activation.MimetypesFileTypeMap;

@Controller
public class MainPageController {

    DaoProvider daoProvider;

    @Autowired
    public MainPageController(DaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    @GetMapping("/image")
    public @ResponseBody
    ResponseEntity<byte[]> getPicture(@RequestParam int id) {
        Picture picture = daoProvider.getPictureDao().get(id);
        return ResponseEntity.ok()
                .contentLength(picture.getData().length)
                .contentType(MediaType.parseMediaType(new MimetypesFileTypeMap().getContentType(picture.getName())))
                .body(picture.getData());
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("addresses", daoProvider.getAddressDao().getAll());
        model.addAttribute("customers", daoProvider.getCustomerDao().getAll());
        model.addAttribute("history", daoProvider.getHistoryDao().getAll());
        model.addAttribute("licenses", daoProvider.getLicenseDao().getAll());
        model.addAttribute("messengers", daoProvider.getMessengerDao().getAll());
        model.addAttribute("partners", daoProvider.getPartnerDao().getAll());
        model.addAttribute("phones", daoProvider.getPhoneDao().getAll());
        model.addAttribute("requisites", daoProvider.getRequisiteDao().getAll());
        model.addAttribute("services", daoProvider.getServiceDao().getAll());
        model.addAttribute("common", daoProvider.getCommonDao().get(0));
        return "index2";
    }

}
