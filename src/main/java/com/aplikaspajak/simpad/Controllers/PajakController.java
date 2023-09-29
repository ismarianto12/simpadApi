package com.aplikaspajak.simpad.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/app")
public class PajakController {

  @Autowired
  private JdbcTemplate jdbc;

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

  @GetMapping("/user")
  public String Listuser(Model model) {
    String Query = "Select * from user";

    List<Map<String, Object>> datauser = jdbc.queryForList(Query);
    model.addAttribute("title", "List data user");

    return "/frontend/listuser";
  }

  @GetMapping("level")
  public String Level(Model model) {
    String query = "Select * from leve";
    List<Map<String, Object>> leveldata = jdbc.queryForList(query);
    Map<String, Object> putdata = new HashMap<>();
    putdata.put("level", leveldata);
    model.addAttribute("Judul", "Level Akses User");
    model.addAttribute("leveldata", putdata);
    return "/frontend/level";
  }
}
