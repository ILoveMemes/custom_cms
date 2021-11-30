package com.example.cmsexample.controllers;

import com.example.cmsexample.dao.UsersDao;
import com.example.cmsexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UsersDao usersDao;

    @Autowired
    public UserController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/edit")
    public String editPage(Model model) {
        List<User> users = usersDao.getAll();
        User copy = new User();
        copy.setId(users.get(0).getId());
        copy.setLogin(users.get(0).getLogin());
        model.addAttribute("data", copy);
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("data") User data) {
        usersDao.update(data);
        return "redirect:/admin";
    }

}
