package com.aplikaspajak.simpad.Controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class PajakController {

  @GetMapping
  public ResponseEntity<Map<String, Object>> welcome() {
    Map<String, Object> res = new HashMap<>();
    res.put("v1", "status");
    return ResponseEntity.ok(res);
  }

  @PostMapping
  public String insert() {
    return "return insert";
  }
}
