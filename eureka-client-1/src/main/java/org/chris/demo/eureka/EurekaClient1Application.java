package org.chris.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class EurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

    @RestController
    @RequiredArgsConstructor
    public static class Client1Controller {

        private final RestTemplate client2;

        @GetMapping("/api/hello")
        public String hello() {
            return client2.getForObject("/hello", String.class);
        }

    }

    @Bean
    @LoadBalanced
    public RestTemplate client2(RestTemplateBuilder builder) {
        return builder
            .rootUri("http://client2/api")
            .build();
    }

}
