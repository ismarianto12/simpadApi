package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.UserModel;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired
  private JdbcTemplate jdbctemplate;

  @PostMapping("actionlogin")
  public ResponseEntity<Map<String, Object>> postMethodName(
    @RequestBody UserModel entity
  ) {
    String username = entity.getUsername();
    String password = entity.getPassword();
    BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
    String encpPasswd = encode.encode(password);

    String query =
      "SELECT id, username, password FROM user WHERE username = ? ";
    List<Map<String, Object>> data = jdbctemplate.queryForList(query, username);

    Map<String, Object> mapdata = new HashMap<>();
    Map<String, Object> resultdata = data.get(0);
    String cpassword = resultdata.get("password").toString();

    boolean matchPas = encode.matches(password, cpassword);
    if (matchPas && !data.isEmpty()) {
      mapdata.put("status", "Success");
      mapdata.put("data", data);
      mapdata.put("response", "Login Berhasil");
      mapdata.put("HTTP_RESPONSE", "ok");

      return ResponseEntity.ok(mapdata);
    } else {
      mapdata.put("response", matchPas);
      mapdata.put("messages", "Username dan password anda salah.");
      return ResponseEntity.badRequest().body(mapdata);
    }
  }
}
