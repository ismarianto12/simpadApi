package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.UserModel;
import com.aplikaspajak.simpad.Services.Userservice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private Userservice userservice;

  private JdbcTemplate jdbc;

  @GetMapping
  public ResponseEntity<Map<String, Object>> getAllUsersWithTmuserLevel() {
    String sql =
      "SELECT * FROM user u LEFT JOIN tmuser_level t ON u.tmuser_level_id = t.id";

    List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
    Map<String, Object> response = new HashMap<>();
    response.put("response", "success");
    response.put("data", result);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  //   public ResponseEntity<Map<String, Object>> getAllUsersWithTmuserLevel() {
  //     String sql = "SELECT * FROM user u LEFT JOIN tmuser_level t ON u.tmuser_level_id = t.id";

  //     List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

  //     Map<String, Object> response = new HashMap<>();
  //     response.put("response data", result);

  //     return new ResponseEntity<>(response, HttpStatus.OK);
  // }

  @GetMapping("user/{id}")
  public ResponseEntity<Map<String, Object>> findByid(@PathVariable Long id) {
    UserModel data = userservice.findOne(id);
    Map<String, Object> res = new HashMap<>();
    res.put("data", data);
    return ResponseEntity.ok(res);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insertdata(
    @RequestBody UserModel usermodel,
    @RequestParam("username") String username,
    @RequestParam("realname") String realname,
    @RequestParam("password") String password,
    @RequestParam("user_id") String user_id
  ) {
    System.out.println(username + "get ");
    usermodel.setUsername(username);
    usermodel.setPassword(password);
    usermodel.setRealname(realname);
    usermodel.setRealname(realname);
    userservice.save(usermodel);
    Map<String, Object> response = new HashMap<>();

    response.put(username, "berhasil di simpan");

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, Object>> updateData(
    @PathVariable Long id,
    @RequestBody Map<String, Object> payload
  ) {
    // Assuming you have a userService method to fetch the existing user
    UserModel user = userservice.findOne(id);

    if (user == null) {
      // Handle the case where the user with the given id doesn't exist
      Map<String, Object> errorResponse = new HashMap<>();
      errorResponse.put("message", "User not found");
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Assuming you want to update username and realname from the payload
    String username = (String) payload.get("username");
    String realname = (String) payload.get("realname");

    // Update the user model
    user.setUsername(username);
    user.setRealname(realname);
    // Save the updated user
    userservice.save(user);
    Map<String, Object> response = new HashMap<>();
    response.put("message", "User updated successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Object>> deletedata(@PathVariable Long id) {
    userservice.delete(id);

    Map<String, Object> response = new HashMap<>();
    response.put("response", "berhasil hapus data");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
