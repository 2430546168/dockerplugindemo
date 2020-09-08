package com.dockerplugindemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zsg
 * @create: 2020/9/3 14:32
 * @description:
 */

@RestController
public class DockerController {

    @RequestMapping("/11111")
    public String index() {
        return "Hello Docker!";
    }
}
