package com.nomad.riborekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-info")
    public String getInfo(){
        String url = "http://rest-app/get-info";
        String ret = restTemplate.getForObject(url, String.class);
        return ret;
    }
}
