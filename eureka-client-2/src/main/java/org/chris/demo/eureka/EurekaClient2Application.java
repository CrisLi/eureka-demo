package org.chris.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class EurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }

    @RestController
    @Slf4j
    public static class Client1Controller {

        @GetMapping("/api/hello")
        public String hello() {

            log.info("hello world");

            return "hello from client2";
        }

    }

}
