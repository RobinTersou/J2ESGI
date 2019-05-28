package com.rtersou.j2eapp.controllers;

@RestController
public class HomeController {
    @GetMapping("/home")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
                .mapToObj(i -> "Hello number " + i)
                .collect(Collectors.toList());
    }
}