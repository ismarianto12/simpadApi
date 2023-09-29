package com.aplikaspajak.simpad.Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tmpegawai")
public class Pad_tahun {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String tahun;
  private String active;
  private String created_by;
  private String created_at;
  private String updated_by;
  private String updated_at;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTahun() {
    return tahun;
  }

  public void setTahun(String tahun) {
    this.tahun = tahun;
  }

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  public String getCreated_by() {
    return created_by;
  }

  public void setCreated_by(String created_by) {
    this.created_by = created_by;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(String updated_by) {
    this.updated_by = updated_by;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }
}
