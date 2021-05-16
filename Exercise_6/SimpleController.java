package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SimpleController {
    static Random rand = new Random();
    @GetMapping("/random")
    public String getRandomNumber(@RequestParam(value = "number", defaultValue = "1000") Integer number) {
        int randNumber = rand.nextInt(number)+1;
        return String.format("<h2>Generate random integers in range 1 to %d: %d</h2>", number, randNumber);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "a", defaultValue = "0") Integer a,
                           @RequestParam(value = "b", defaultValue = "0") Integer b) {
        return String.format("<h2>%d * %d = %d</h2>", a, b, a * b);
    }

    @GetMapping("/greet/{name}")
    public String helloMyDarling(@PathVariable("name") String name) {
        return String.format("<h2>Hello %s!</h2>", name);
    }
}
