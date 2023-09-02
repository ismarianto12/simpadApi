package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Repository.Padrepo;
import com.aplikaspajak.simpad.Services.Padservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paddata")
public class PadController {

  @Autowired
  private Padservice padservice;

  private Padrepo padrepository;

  @PostMapping
  public ResponseEntity<Map<String, Object>> create(
    @RequestBody Padmodel padmodel
  ) {
    try {
      padservice.save(padmodel);

      Map<String, Object> response = new HashMap<>();
      response.put("Status", "Berhasil");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("gagal", e);
      return ResponseEntity.ok(response);
    }
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> allData() {
    Iterable<Padmodel> data = padservice.findAll();

    List<Map<String, Object>> formattedData = new ArrayList<>();
    for (Padmodel pad : data) {
      Map<String, Object> item = new HashMap<>();
      item.put("id", pad.getId());
      item.put("kode", pad.getKode());
      item.put("nama", pad.getNama());
      item.put("tarif_pajak", pad.getTarif_pajak());
      formattedData.add(item);
    }

    Map<String, Object> response = new HashMap<>();
    response.put("status", "success");
    response.put("data", formattedData);

    return ResponseEntity.ok(response);
  }

  @PostMapping("update/{id}")
  public ResponseEntity<Map<String, Object>> update(
    @RequestBody Padmodel request,
    @PathVariable Long id
  ) {
    try {
      Padmodel padmodel = padservice.findOne(id);
      System.out.println(request + "asadsa");

      Map<String, Object> response = new HashMap<>();
      response.put("data", padmodel);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("gagal", e);

      return ResponseEntity.ok(response);
    }
  }
}
