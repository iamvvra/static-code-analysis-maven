package com.example.demo.resources;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

  @GetMapping("/hello/{name}")
  public String sayHello(@PathVariable String name) {
    return "Hello " + Optional.ofNullable(name).orElse("world");
  }
}
