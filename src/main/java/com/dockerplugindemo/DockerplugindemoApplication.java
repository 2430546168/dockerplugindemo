package com.dockerplugindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class DockerplugindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerplugindemoApplication.class, args);
    }

    @RequestMapping("/test123")
    public String test(){
        return "1. Hello world ! " + new SimpleDateFormat(" [yyyy-mm-dd  HH:mm:ss]").format(new Date());
    }

//    @RequestMapping("/test2")
//    public String test2(){
//        return "12. Hello world2 ! " + new SimpleDateFormat(" [yyyy-mm-dd  HH:mm:ss]").format(new Date());
//    }
}
