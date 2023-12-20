package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Repository.Padrepo;
import com.aplikaspajak.simpad.Services.Padservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/paddata")
public class PadController {

  @Autowired
  private Padservice padservice;

  @Autowired
  private Padrepo padrepository;

  @PostMapping
  public ResponseEntity<Map<String, Object>> create(
    @Valid @RequestBody Padmodel padmodel
  ) {
    try {
      Map<String, Object> response = new HashMap<>();
      if (padmodel.getKode().isEmpty()) {
        response.put("Status", "Berhasil");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
      }
      padservice.save(padmodel);

      response.put("Status", "Berhasil");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("gagal", e);
      return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
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
      padservice.findOne(id);
      //string  = request.get("name");

      //   padmodel.setKode(request.getKode());
      //   padmodel.setKode(request.getNama());
      //   padmodel.setTarif_pajak(request.getTarif_pajak());
      padservice.save(request);
      Map<String, Object> response = new HashMap<>();
      response.put("data", "succes update data");

      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("gagal", e);

      return ResponseEntity.ok(response);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Map<String, Object>> deletedata(@PathVariable Long id) {
    try {
      padservice.removeOne(id);
      Map<String, Object> response = new HashMap<>();
      response.put("messages", "berhasil di hapus");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      // TODO: handle exception
      Map<String, Object> response = new HashMap<>();
      response.put("messages", e.getMessage());
      return ResponseEntity.ok(response);
    }
  }
}
