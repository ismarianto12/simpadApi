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
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<Map<String, Object>> getAll() {
    String query = "SELECT * from esptpd";
    List<Map<String, Object>> resdata = jdbcTemplate.queryForList(query);
    Map<String, Object> response = new HashMap<>();
    response.put("data", resdata);
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    Estpdmodel esptpdmodel,
    @RequestParam("file") MultipartFile file,
    @RequestParam("bukti_bayar") String bukti_bayar,
    @RequestParam("bunga") String bunga,
    @RequestParam("denda") String denda,
    @RequestParam("is_deleted") String is_deleted,
    @RequestParam("jumlah") String jumlah,
    @RequestParam("kd_rekening") String kd_rekening,
    @RequestParam("keterangan") String keterangan,
    @RequestParam("ntb") String ntb,
    @RequestParam("omset") String omset,
    @RequestParam("pad_tahun_id") String pad_tahun_id,
    @RequestParam("ref_id") String ref_id,
    @RequestParam("satuan") String satuan,
    @RequestParam("status") String status,
    @RequestParam("tahun") String tahun,
    @RequestParam("tanggal_lapor") String tanggal_lapor
  ) {
    try {
      String exampletoken = "Berhasil";
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());

      System.out.printf(fileName, "/n");
      esptpdmodel.setBukti_bayar(fileName.toString());
      esptpdmodel.setDenda(denda);
      esptpdmodel.setIs_deleted(is_deleted);
      esptpdmodel.setJumlah(jumlah);
      esptpdmodel.setKd_rekening(kd_rekening);
      esptpdmodel.setKeterangan(keterangan);
      esptpdmodel.setNtb(ntb);
      esptpdmodel.setOmset(omset);
      esptpdmodel.setPad_tahun_id(pad_tahun_id);
      esptpdmodel.setRef_id(ref_id);
      esptpdmodel.setSatuan(satuan);
      esptpdmodel.setStatus(status);
      esptpdmodel.setTahun(tahun);
      esptpdmodel.setTanggal_lapor(tanggal_lapor);
      esptpdmodel.setBunga(bunga);
      esptpdservice.save(esptpdmodel);

      String uploadDir = "uploads/";
      FileUploadUtil.saveFile(uploadDir, fileName, file);
      Map<String, Object> response = new HashMap<>();
      response.put("messages", "berhasil di update");
      return ResponseEntity.ok(response);
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
