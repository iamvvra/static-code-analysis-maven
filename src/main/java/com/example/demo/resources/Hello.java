package com.example.demo.resources;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/** A volatile storage for objects based on a key, which may be invalidated and discarded. */
@RestController
public class Hello {

  /**
   * Says hello to the name
   *
   * @param name The string to split. An {@code null} string is treated as an empty string.
   * @return A hello + the name
   */
  @GetMapping("/hello/{name}")
  public String sayHello(@PathVariable final String name) {
    return "Hello " + Optional.ofNullable(name).orElse("world");
  }
}
