package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Tmwajib_pajakmodel;
import com.aplikaspajak.simpad.Services.Tmwajibpajakservice;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/app")
public class PajakController {

  @Autowired
  private JdbcTemplate jdbc;

  private Tmwajibpajakservice wajibpajakservice;

  @GetMapping("/get/{id}")
  public ResponseEntity<Map<String, Object>> getDataPajak() {
    Map<String, Object> resdata = new HashMap<>();
    resdata.put("Status", "response");
    return ResponseEntity.ok(resdata);
  }

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

  @PostMapping("/bungapajak")
  public ResponseEntity<Map<String, Object>> postMethodName(
    @RequestBody Tmwajib_pajakmodel pajak
  ) {
    String data = pajak.getBunga();
    String tahun = pajak.getTahun();

    Map<String, Object> putdata = new HashMap<>();
    putdata.put("reqest", pajak);
    return ResponseEntity.ok(putdata);
  }

  @GetMapping("/user")
  public String Listuser(Model model) {
    String Query = "Select * from user";

    List<Map<String, Object>> datauser = jdbc.queryForList(Query);
    model.addAttribute("title", "List data user");

    return "/frontend/listuser";
  }

  @PostMapping("/sortingBynpwp")
  public ResponseEntity<Map<String, Object>> sortingBynpwp() {
    HashMap<String, Object> listdata = new HashMap<>();
    // Iterable<Tmwajib_pajakmodel> datanwpwp = wajibpajakservice.findAll();
    String Query = "Select user.username, realname, telp from user";

    List<Map<String, Object>> datauser = jdbc.queryForList(Query);

    listdata.put("response", "successful");
    listdata.put("response", datauser);
    listdata.put("httpresponse", "200");

    return ResponseEntity.ok(listdata);
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
