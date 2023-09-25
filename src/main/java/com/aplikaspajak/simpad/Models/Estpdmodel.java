package com.aplikaspajak.simpad.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "esptpd")
public class Estpdmodel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @NotNull(message = "Bunga Bayar Is Reqiuired")
  private String bukti_bayar;

  // @NotNull(message = "Bunga Bayar Is Reqiuired")
  private String bunga;

  private String created_at;
  private String created_by;

  // @NotNull(message = "Denda Is Reqiuired")
  private String denda;

  private String id;
  private String is_deleted;

  // @NotNull(message = "Jumlah Is Reqiuired")
  private String jumlah;

  private String kd_rekening;
  private String keterangan;
  private String ntb;
  private String omset;
  private String pad_tahun_id;
  private String ref_id;
  private String satuan;

  // @NotNull(message = "Status Is Reqiuired")
  private String status;

  private String tahun;
  private String tanggal_lapor;
  private String tmpad_id;
  private String tmwajib_pajak_id;
  private String updated_at;
  private String updated_by;
  private String volume;

  public Estpdmodel() {}

  public Estpdmodel(
    String bukti_bayar,
    String bunga,
    String created_at,
    String created_by,
    String denda,
    String id,
    String is_deleted,
    String jumlah,
    String kd_rekening,
    String keterangan,
    String ntb,
    String omset,
    String pad_tahun_id,
    String ref_id,
    String satuan,
    String status,
    String tahun,
    String tanggal_lapor,
    String tmpad_id,
    String tmwajib_pajak_id,
    String updated_at,
    String updated_by,
    String volume
  ) {
    this.bukti_bayar = bukti_bayar;
    this.bunga = bunga;
    this.created_at = created_at;
    this.created_by = created_by;
    this.denda = denda;
    this.id = id;
    this.is_deleted = is_deleted;
    this.jumlah = jumlah;
    this.kd_rekening = kd_rekening;
    this.keterangan = keterangan;
    this.ntb = ntb;
    this.omset = omset;
    this.pad_tahun_id = pad_tahun_id;
    this.ref_id = ref_id;
    this.satuan = satuan;
    this.status = status;
    this.tahun = tahun;
    this.tanggal_lapor = tanggal_lapor;
    this.tmpad_id = tmpad_id;
    this.tmwajib_pajak_id = tmwajib_pajak_id;
    this.updated_at = updated_at;
    this.updated_by = updated_by;
    this.volume = volume;
  }

  public String getBukti_bayar() {
    return bukti_bayar;
  }

  public void setBukti_bayar(String bukti_bayar) {
    this.bukti_bayar = bukti_bayar;
  }

  public String getBunga() {
    return bunga;
  }

  public void setBunga(String bunga) {
    this.bunga = bunga;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getCreated_by() {
    return created_by;
  }

  public void setCreated_by(String created_by) {
    this.created_by = created_by;
  }

  public String getDenda() {
    return denda;
  }

  public void setDenda(String denda) {
    this.denda = denda;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIs_deleted() {
    return is_deleted;
  }

  public void setIs_deleted(String is_deleted) {
    this.is_deleted = is_deleted;
  }

  public String getJumlah() {
    return jumlah;
  }

  public void setJumlah(String jumlah) {
    this.jumlah = jumlah;
  }

  public String getKd_rekening() {
    return kd_rekening;
  }

  public void setKd_rekening(String kd_rekening) {
    this.kd_rekening = kd_rekening;
  }

  public String getKeterangan() {
    return keterangan;
  }

  public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
  }

  public String getNtb() {
    return ntb;
  }

  public void setNtb(String ntb) {
    this.ntb = ntb;
  }

  public String getOmset() {
    return omset;
  }

  public void setOmset(String omset) {
    this.omset = omset;
  }

  public String getPad_tahun_id() {
    return pad_tahun_id;
  }

  public void setPad_tahun_id(String pad_tahun_id) {
    this.pad_tahun_id = pad_tahun_id;
  }

  public String getRef_id() {
    return ref_id;
  }

  public void setRef_id(String ref_id) {
    this.ref_id = ref_id;
  }

  public String getSatuan() {
    return satuan;
  }

  public void setSatuan(String satuan) {
    this.satuan = satuan;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTahun() {
    return tahun;
  }

  public void setTahun(String tahun) {
    this.tahun = tahun;
  }

  public String getTanggal_lapor() {
    return tanggal_lapor;
  }

  public void setTanggal_lapor(String tanggal_lapor) {
    this.tanggal_lapor = tanggal_lapor;
  }

  public String getTmpad_id() {
    return tmpad_id;
  }

  public void setTmpad_id(String tmpad_id) {
    this.tmpad_id = tmpad_id;
  }

  public String getTmwajib_pajak_id() {
    return tmwajib_pajak_id;
  }

  public void setTmwajib_pajak_id(String tmwajib_pajak_id) {
    this.tmwajib_pajak_id = tmwajib_pajak_id;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public String getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(String updated_by) {
    this.updated_by = updated_by;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }
}
