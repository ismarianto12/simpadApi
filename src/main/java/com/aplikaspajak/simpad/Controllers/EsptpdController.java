package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Services.Esptpdservice;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/esptpd")
public class EsptpdController {

  private Esptpdservice esptpdservice;

  @GetMapping("all")
  public Iterable<Estpdmodel> getAll() {
    return esptpdservice.getAll();
  }

  @PostMapping
  public Estpdmodel insert(@RequestBody Estpdmodel esptpdmodel) {
    return esptpdservice.save(esptpdmodel);
  }

  // public Estpdmodel
  @PostMapping("update/{id}")
  public ResponseEntity<Map<String, Object>> updateEspt(
    @RequestBody Estpdmodel modeldata,
    @PathVariable Long Id
  ) {
    try {
      Map<String, Object> response = new HashMap<>();
      esptpdservice.findOne(Id);
      esptpdservice.save(modeldata);

      response.put("messages", "data berhasil di Edit ");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      esptpdservice.findOne(Id);
      esptpdservice.save(modeldata);
      response.put("messages", e.getMessage());
      return ResponseEntity.ok(response);
    }
  }
}
