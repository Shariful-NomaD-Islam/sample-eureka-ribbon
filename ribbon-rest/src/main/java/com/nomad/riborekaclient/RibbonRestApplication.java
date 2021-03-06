package com.nomad.riborekaclient;

import com.nomad.riborekaclient.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClients({
		@RibbonClient(name = "rest-app",configuration = RibbonConfiguration.class),
		@RibbonClient(name = "rest-app2",configuration = RibbonConfiguration.class)
})
public class RibbonRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonRestApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
