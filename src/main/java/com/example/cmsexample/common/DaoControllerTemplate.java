package com.example.cmsexample.common;

import com.example.cmsexample.controllers.PictureController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.crypto.Data;

public abstract class DaoControllerTemplate<DataType> {

    // string const to interact with html
    abstract public String getIndexPage();
    abstract public String getInfoPage();
    abstract public DataType dataInstanceBuilder();

    DaoTemplate<DataType> daoInstance;
    PictureController pictureController;

    public DaoControllerTemplate(DaoTemplate<DataType> daoInstance, PictureController pictureController) {
        this.daoInstance = daoInstance;
        this.pictureController = pictureController;
    }

    @GetMapping("/info")
    public String infoPage(Model model) {
        model.addAttribute("data", daoInstance.getAll());
        return getIndexPage();
    }

    @GetMapping("/{id}")
    public DataType get(@PathVariable int id) {
        return daoInstance.get(id);
    }

    @GetMapping("/{id}/info")
    public String getInfo(Model model, @PathVariable int id) {
        model.addAttribute("data", daoInstance.get(id));
        model.addAttribute("pictures", pictureController.getAllId());
        return getInfoPage();
    }

    @GetMapping("/create")
    public String addPage(Model model) {
        model.addAttribute("_action", "add");
        model.addAttribute("data", dataInstanceBuilder());
        model.addAttribute("pictures", pictureController.getAllId());
        return getInfoPage();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("data") DataType data) {
        //DataType data = (DataType) model.getAttribute(getSingleDataName());
        //DataType data = (DataType) model.asMap().get(getSingleDataName());
        daoInstance.save(data);
        return "redirect:/" + getInfoPage();
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("data") DataType data) {
        //DataType data = (DataType) model.getAttribute(getSingleDataName());
        //DataType data = (DataType) model.asMap().get(getSingleDataName());
        daoInstance.update(data);
        return "redirect:/" + getInfoPage();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        daoInstance.delete(id);
        return "redirect:/" + getInfoPage();
    }

}
