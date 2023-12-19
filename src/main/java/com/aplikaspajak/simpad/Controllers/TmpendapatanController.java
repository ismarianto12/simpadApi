package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Services.Esptpdservice;
import com.aplikaspajak.simpad.Services.Padservice;
import com.aplikaspajak.simpad.Utils.FileUploadUtil;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TmpendapatanController {

  @Autowired
  private JdbcTemplate jdbctemplate;

  @Autowired
  private Esptpdservice esptpdservice;

  @Autowired
  private Padservice padservice;

  @GetMapping("tmpendapatan/list")
  public ResponseEntity<Map<String, Object>> Alldata() {
    try {
      String query = "SELECT * from tmpendapatan";
      List<Map<String, Object>> rest = jdbctemplate.queryForList(query);
      Map<String, Object> response = new HashMap<>();

      response.put("messages", "success");
      response.put("data", rest);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>();
      response.put("Error", e.getMessage());
      return ResponseEntity.ok(response);
    }
  }

  @PostMapping("pendapatan/insert")
  public ResponseEntity<Map<String, Object>> simpanData(
    @RequestBody Estpdmodel modeldata,
    @RequestParam("file") MultipartFile file
  ) {
    try {
      Map<String, Object> res = new HashMap<>();

      modeldata.setDenda(modeldata.getDenda());
      modeldata.setStatus(modeldata.getStatus());
      modeldata.setBunga(modeldata.getBunga());
      modeldata.setBukti_bayar(modeldata.getBukti_bayar());

      String fileName = StringUtils.cleanPath(modeldata.getBukti_bayar());
      String uploadDir = "uploads/";
      FileUploadUtil.saveFile(uploadDir, fileName, file);
      esptpdservice.save(modeldata);
      res.put("response", "200");
      res.put("messages", "data berhasil di simpan .");

      return ResponseEntity.ok(res);
    } catch (Exception e) {
      Map<String, Object> res = new HashMap<>();
      res.put("response", e.getMessage());
      return ResponseEntity.ok(res);
    }
  }

  /**
   * @return
   */
  public String getallYear() {
    final String query = "select tahun from pad_tahun limit 1";
    final String padtahun = jdbctemplate.queryForObject(query, String.class);
    return padtahun;
  }

  @GetMapping("/pendapatanview")
  public String getView(Model model) {
    Map<String, String> data = new HashMap<>();
    data.put("TEST", "asda");
    data.put("adsada", "asdada");
    model.addAttribute("message", "Hello, Worlds!");
    model.addAttribute("title", "Sistem Perpajakan Daerahs");
    model.addAttribute("listdata", data);
    model.addAttribute("tanggal", getallYear());
    return "myView";
  }

  @GetMapping("/loginapp")
  public String LoginPage(Model model) {
    Map<String, Object> formdata = new HashMap<>();
    formdata.put("login", "Halaman Login Page");
    model.addAttribute("login", "Login Page.");
    return "/frontend/login";
  }

  @GetMapping("/dashboard")
  public String Dashboard(Model model) {
    try {
      model.addAttribute("title", "Welcome Dashboard");
      return "/frontend/dashboard";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @GetMapping("/realisasipad")
  public String Getrealisasi(Model model) {
    Map<String, Object> arrdata = new HashMap<>();
    Iterable<Padmodel> pajak = padservice.findAll();

    var padtahun = getallYear();

    arrdata.put("Halaman", "Dashboard Realisasi");
    arrdata.put("padtahun", padtahun);
    // arrdata.put("TahunPad",padtahun);

    model.addAttribute("resdata", arrdata);
    model.addAttribute("pajak", pajak);
    return "/frontend/realisasi";
  }

  private Object getTahunActive() {
    return getallYear();
  }
}
