package com.nomad.rest2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${app.id}")
    String instance;

    @Value("${server.port}")
    String port;

    @GetMapping("/rest-get-string")
    public String information() {
        logger.info("rest-app2: get-string called");
        return "Returned string" + "(" + port + ")" + ": " + instance;
    }

}
