package com.api.controller;

import com.api.entity.Format;
import com.api.service.FormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing")
public class FormatController {
    @Autowired
    FormatService formatService;

    @GetMapping("/formats")
    public List<Format> getAllFormats(){
        return formatService.getAllFormats();
    }

    @GetMapping("/formats/{formatId}")
    public Format getFormatById(@PathVariable("formatId") int formatId){
        return formatService.getFormatById(formatId);
    }

//    @PostMapping("/formats")
//    public String addFormats(@RequestBody Format format){
//        return formatService.addFormats(format);
//    }

    @PostMapping("/formats")
    public String addFormats(@RequestBody List<Format> formats){
        return formatService.addFormatsList(formats);
    }

    @DeleteMapping("/formats/{formatId}")
    public String deleteFormat(@PathVariable("formatId") int formatId){
        return formatService.deleteFormat(formatId);
    }

    @PutMapping("/formats/{formatId}")
    public String updateFormat(@PathVariable("formatId") int formatId, @RequestBody Format format){
        return formatService.updateFormat(formatId, format);
    }
}
