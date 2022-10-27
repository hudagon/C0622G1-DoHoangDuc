package com.ss10.controller;

import com.ss10.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/count")
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }


    @GetMapping("/home")
    public String get(@SessionAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}
