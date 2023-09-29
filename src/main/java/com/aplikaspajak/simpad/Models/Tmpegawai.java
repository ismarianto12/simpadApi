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
public class Tmpegawai {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String sikd_satker_id;
  private String jabatanid;

  private String pegawaistatusid;
  private String d_masuk;
  private String d_keluar;

  private String nip;

  private String n_pegawai;
  private String telp;
  private String alamat;
  private String dinasid;
  private String bidangid;
  private String d_kontrak;
  private String updated_at;
  private String created_at;

  public Tmpegawai(
    Long id,
    String sikd_satker_id,
    String jabatanid,
    String pegawaistatusid,
    String d_masuk,
    String d_keluar,
    String nip,
    String n_pegawai,
    String telp,
    String alamat,
    String dinasid,
    String bidangid,
    String d_kontrak,
    String updated_at,
    String created_at
  ) {
    this.id = id;
    this.sikd_satker_id = sikd_satker_id;
    this.jabatanid = jabatanid;
    this.pegawaistatusid = pegawaistatusid;
    this.d_masuk = d_masuk;
    this.d_keluar = d_keluar;
    this.nip = nip;
    this.n_pegawai = n_pegawai;
    this.telp = telp;
    this.alamat = alamat;
    this.dinasid = dinasid;
    this.bidangid = bidangid;
    this.d_kontrak = d_kontrak;
    this.updated_at = updated_at;
    this.created_at = created_at;
  }

  public Tmpegawai() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSikd_satker_id() {
    return sikd_satker_id;
  }

  public void setSikd_satker_id(String sikd_satker_id) {
    this.sikd_satker_id = sikd_satker_id;
  }

  public String getJabatanid() {
    return jabatanid;
  }

  public void setJabatanid(String jabatanid) {
    this.jabatanid = jabatanid;
  }

  public String getPegawaistatusid() {
    return pegawaistatusid;
  }

  public void setPegawaistatusid(String pegawaistatusid) {
    this.pegawaistatusid = pegawaistatusid;
  }

  public String getD_masuk() {
    return d_masuk;
  }

  public void setD_masuk(String d_masuk) {
    this.d_masuk = d_masuk;
  }

  public String getD_keluar() {
    return d_keluar;
  }

  public void setD_keluar(String d_keluar) {
    this.d_keluar = d_keluar;
  }

  public String getNip() {
    return nip;
  }

  public void setNip(String nip) {
    this.nip = nip;
  }

  public String getN_pegawai() {
    return n_pegawai;
  }

  public void setN_pegawai(String n_pegawai) {
    this.n_pegawai = n_pegawai;
  }

  public String getTelp() {
    return telp;
  }

  public void setTelp(String telp) {
    this.telp = telp;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getDinasid() {
    return dinasid;
  }

  public void setDinasid(String dinasid) {
    this.dinasid = dinasid;
  }

  public String getBidangid() {
    return bidangid;
  }

  public void setBidangid(String bidangid) {
    this.bidangid = bidangid;
  }

  public String getD_kontrak() {
    return d_kontrak;
  }

  public void setD_kontrak(String d_kontrak) {
    this.d_kontrak = d_kontrak;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }
}
