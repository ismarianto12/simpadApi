package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Services.Padservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paddata")
public class PadController {

  @Autowired
  private Padservice padservice;

  @PostMapping
  public Padmodel create(@RequestBody Padmodel padmodel) {
    return padservice.save(padmodel);
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
}
