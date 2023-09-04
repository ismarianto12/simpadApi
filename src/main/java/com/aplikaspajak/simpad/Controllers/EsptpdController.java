package com.aplikaspajak.simpad.Controllers;

// import antlr.StringUtils;
import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Services.Esptpdservice;
import com.aplikaspajak.simpad.Utils.FileUploadUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// import Fileu

@RestController
@RequestMapping("api/esptpd")
public class EsptpdController {

  @Autowired
  private Esptpdservice esptpdservice;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("all")
  public Iterable<Estpdmodel> getAll() {
    return esptpdservice.findAll();
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    @RequestPart MultipartFile file
    // @RequestPart Estpdmodel esptpdmodel
  ) {
    try {
      String exampletoken = "testing";
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      // esptpdmodel.setBukti_bayar(fileName);
      // esptpdservice.save(esptpdmodel);
      String uploadDir = "uploads/";
      FileUploadUtil.saveFile(uploadDir, fileName, file);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("messages", e.getMessage());
      return ResponseEntity.ok(response);
    }
  }

  @GetMapping("/detail/{id}")
  public Estpdmodel detail(@PathVariable Long id) {
    return esptpdservice.findOne(id);
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity<Map<String, Object>> deletel(@PathVariable Long id) {
    Map<String, Object> response = new HashMap<>();
    esptpdservice.delete(id);
    response.put("message", "data berhasil di hapus");
    return ResponseEntity.ok(response);
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
      response.put("messages", e.getMessage());
      return ResponseEntity.ok(response);
    }
  }
}
