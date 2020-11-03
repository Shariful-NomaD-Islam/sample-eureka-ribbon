package com.nomad.riborekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restApp;

    @GetMapping("/service-info")
    public int serviceInfo(){
        logger.info("ribbon-rest: service-info is called...");
        List<ServiceInstance> instanceInfos = this.discoveryClient.getInstances("rest-app");
        return instanceInfos.size();
    }

    @GetMapping("/get-info")
    public String getInfo(){
        logger.info("ribbon-rest: get-info is called...");
        String url = "http://rest-app/rest-get-info";
        String ret = restApp.getForObject(url, String.class);
        return ret;
    }

    @GetMapping("/get-string")
    public String getString(){
        logger.info("ribbon-rest: get-string is called...");
        String url = "http://rest-app2/rest-get-string";
        String ret = restApp.getForObject(url, String.class);
        return ret;
    }
}
