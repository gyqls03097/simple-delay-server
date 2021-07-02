package com.example.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

  @GetMapping("/api/v1/simple")
  public String simple(@RequestParam(value = "delay_ms", defaultValue = "0") long delayMillis)
      throws InterruptedException {

    Thread.sleep(delayMillis);
    return "succeed";
  }
}
