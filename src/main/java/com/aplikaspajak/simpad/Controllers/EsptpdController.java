package com.aplikaspajak.simpad.Controllers;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Services.Esptpdservice;
import org.springframework.web.bind.annotation.GetMapping;
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

}
