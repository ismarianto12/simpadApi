package com.aplikaspajak.simpad.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class PajakController {

  @GetMapping
  public String welcome() {
    return "response java";
  }

  @PostMapping
  public String insert() {
    return "return insert";
  }
}
