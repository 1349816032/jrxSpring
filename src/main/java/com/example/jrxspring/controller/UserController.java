package com.example.jrxspring.controller;

import com.example.jrxspring.model.UserInformation;
import com.example.jrxspring.repository.UserInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserInformationRepo userInformationRepo;

    @ResponseBody
    @CrossOrigin
    @GetMapping(path = "show")
    public List<UserInformation> show(){
        return userInformationRepo.queryAllUser();
    }
}
