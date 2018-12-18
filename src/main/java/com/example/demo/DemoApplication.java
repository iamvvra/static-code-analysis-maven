package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Splits a string on whitespace. */
@SpringBootApplication
public class DemoApplication {

  /**
   * Splits a string on whitespace.
   *
   * @param args The string to split. An {@code null} string is treated as an empty string.
   */
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
