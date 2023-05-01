package pl.ecommerce.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController {

    @GetMapping("/hello")
    public String hello() {
        return "hey dude";
    }
}
