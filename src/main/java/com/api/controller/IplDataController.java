package com.api.controller;

import com.api.entity.Ipldata;
import com.api.service.IplDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IplDataController {
    @Autowired
    IplDataService iplDataService;


    @PostMapping("/ipldata")
    public String saveIPLData(@RequestBody List<Ipldata> listOfIplData){
        String response = iplDataService.saveIplData(listOfIplData);
        return  response;
    }
}
