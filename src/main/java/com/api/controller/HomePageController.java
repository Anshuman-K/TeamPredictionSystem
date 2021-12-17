package com.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    @GetMapping("/")
    public ResponseEntity<String> homePage(){
        String response =  " { Register: " +
                "   {Endpoint: \"/api/v1/register/create\", " +
                "   body:{\n" +
                "    \"userName\": \"Enter username\",\n" +
                "    \"name\" : \"Enter Name\",\n" +
                "    \"password\" : \"Enter password\",\n" +
                "    \"email\" : \"Enter mail id\"\n } " +
                "     }  " +
                "}";

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
