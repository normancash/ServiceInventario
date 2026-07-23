package org.uam.serviceinventario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class ControllerGreeting {


   @GetMapping("/hi")
    public String sayHello() {
        return "Hello!";
    }


    @GetMapping("/goodbye")
    public String sayGoodbye(String name) {
        return "Goodbye " + name;
    }


}
