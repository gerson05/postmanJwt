package com.icesi.demoBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET HTTP method
    // http: //localhost:8080/
    @GetMapping("/")
    public String message() {
        return "Welcome to Spring Boot Application";
    }

    // GET HTTP method
    // http: //localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
    @GetMapping("/secure-hello")
    public String secureHello() {
        return "This is a secure hello";
    }

}
