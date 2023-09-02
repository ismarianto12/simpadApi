package com.aplikaspajak.simpad.Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tmpad")
public class Padmodel implements Serializable {

  // created_at
  // created_by
  // id
  // kode
  // nama
  // tarif_pajak
  // updated_at
  // updated_by
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Kode Tidak Boleh Kosong")
  private String kode;

  private String nama;
  private Double tarif_pajak;

  public Padmodel() {}

  public Padmodel(Long id, String kode, String nama, Double tarif_pajak) {
    this.id = id;
    this.kode = kode;
    this.nama = nama;
    this.tarif_pajak = tarif_pajak;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getKode() {
    return kode;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public Double getTarif_pajak() {
    return tarif_pajak;
  }

  public void setTarif_pajak(Double tarif_pajak) {
    this.tarif_pajak = tarif_pajak;
  }
}
