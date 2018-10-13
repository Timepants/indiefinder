package com.example.indiefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    // inject via application.yml
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "welcome";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
        return "test";
    }
    @RequestMapping("/index")
    public String index(Map<String, Object> model) {
        return "index";
    }


}