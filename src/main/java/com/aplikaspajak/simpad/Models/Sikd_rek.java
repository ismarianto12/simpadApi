package com.aplikaspajak.simpad.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sikd_rek")
public class Sikd_rek {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nama;
  private String tahun;

  public Sikd_rek() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getTahun() {
    return tahun;
  }

  public void setTahun(String tahun) {
    this.tahun = tahun;
  }
}
