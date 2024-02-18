package example.everytime.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/apis/hello")
    public String hello(HttpServletRequest req) {
        String host = req.getServerName() + ":" + req.getServerPort();
        return "Hello, this is " + host + ".";
    }
}
