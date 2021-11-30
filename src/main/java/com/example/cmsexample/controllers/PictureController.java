package com.example.cmsexample.controllers;

import com.example.cmsexample.models.Picture;
import com.example.cmsexample.models.PictureInfo;
import com.example.cmsexample.dao.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pic")
public class PictureController {

    PictureDao pictureDao;

    @Autowired
    public PictureController(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("pictures", getAllPictureInfo());
        return "pic/index";
    }

    //@GetMapping("/getAllId")
    public List<Integer> getAllId() {
        List<Integer> list = new ArrayList<>();
        pictureDao.getAll().forEach(picture -> list.add(picture.getId()));
        return list;
    }

    public List<PictureInfo> getAllPictureInfo() {
        List<PictureInfo> list = new ArrayList<>();
        pictureDao.getAll().forEach(picture -> list.add(getPictureInfo(picture.getId())));
        return list;
    }

    public PictureInfo getPictureInfo(int id) {
        Picture picture = pictureDao.get(id);
        return new PictureInfo().setId(picture.getId()).setName(picture.getName());
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<byte[]> getPicture(@PathVariable int id) {
        Picture picture = pictureDao.get(id);
        return ResponseEntity.ok()
                .contentLength(picture.getData().length)
                .contentType(MediaType.parseMediaType(new MimetypesFileTypeMap().getContentType(picture.getName())))
                .body(picture.getData());
    }

    @GetMapping("/{id}/info")
    public String getPictureInfo(Model model, @PathVariable int id) {
        model.addAttribute("picture", pictureDao.get(id));
        return "/pic/info";
    }


    @PostMapping("/upload")
    public String uploadPicture(@RequestParam("image") MultipartFile multipartFile) {
        Picture picture = new Picture();
        try {
            picture.setData(multipartFile.getBytes());
            picture.setName(multipartFile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            //return new RedirectView("/admin", true); // with error ?
            return "redirect:/error";
        }
        pictureDao.save(picture);
        return "redirect:/pic/info";
        //return new RedirectView("/admin", true);
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable int id) {
        pictureDao.delete(id);
        return "redirect:/pic/info";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("_action", "add");
        model.addAttribute("picture", new PictureInfo());
        return "pic/info";
    }

}
