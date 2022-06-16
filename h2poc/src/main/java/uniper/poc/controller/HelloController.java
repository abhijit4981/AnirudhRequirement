package uniper.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping({"/hello"})
    public String hello(@RequestParam(value = "name", defaultValue = "World",
            required = true) String name, Model model) {
        //url : http://localhost:9191/hello?name=Abhijit
        model.addAttribute("name", name);
        return "Hello";
    }
    @GetMapping({"/hello/{name}"})
    public String hello1(@PathVariable String name, Model model) {
        //url : http://localhost:9191/hello/Khandu
        model.addAttribute("name", name);
        return "Hello";
    }
}
