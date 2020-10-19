package com.nomad.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${app.id}")
    String instance;

    @Value("${server.port}")
    String port;

    @GetMapping("/get-info")
    public String information() {
        return "Returned information" + "(" + port + ")" + ": " + instance;
    }

}
