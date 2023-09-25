package com.aplikaspajak.simpad.Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Username")
  public String tmpegawai_id;

  public String sikd_satker_id;
  public String username;
  public String realname;
  public String password;
  public String last_login;
  public String telp;
  public String c_status;
  public String photo;
  public String ttd;
  public String paraf;
  public String tmuser_level_id;
  public String jenis;
  public String p12;
  public String created_at;
  public String updated_at;

  public UserModel(
    Long id,
    // @NotNull(message = "Username") String tmpegawai_id,
    String sikd_satker_id,
    // @NotNull(message = "Useraname Required")
    String username,
    String realname,
    String password,
    String last_login,
    String telp,
    String c_status,
    String photo,
    String ttd,
    String paraf,
    String tmuser_level_id,
    String jenis,
    String p12,
    String created_at,
    String updated_at
  ) {
    this.id = id;
    this.tmpegawai_id = tmpegawai_id;
    this.sikd_satker_id = sikd_satker_id;
    this.username = username;
    this.realname = realname;
    this.password = password;
    this.last_login = last_login;
    this.telp = telp;
    this.c_status = c_status;
    this.photo = photo;
    this.ttd = ttd;
    this.paraf = paraf;
    this.tmuser_level_id = tmuser_level_id;
    this.jenis = jenis;
    this.p12 = p12;
    this.created_at = created_at;
    this.updated_at = updated_at;
  }

  public String getSikd_satker_id() {
    return sikd_satker_id;
  }

  public void setSikd_satker_id(String sikd_satker_id) {
    this.sikd_satker_id = sikd_satker_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLast_login() {
    return last_login;
  }

  public void setLast_login(String last_login) {
    this.last_login = last_login;
  }

  public String getTelp() {
    return telp;
  }

  public void setTelp(String telp) {
    this.telp = telp;
  }

  public String getC_status() {
    return c_status;
  }

  public void setC_status(String c_status) {
    this.c_status = c_status;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getTtd() {
    return ttd;
  }

  public void setTtd(String ttd) {
    this.ttd = ttd;
  }

  public String getParaf() {
    return paraf;
  }

  public void setParaf(String paraf) {
    this.paraf = paraf;
  }

  public String getTmuser_level_id() {
    return tmuser_level_id;
  }

  public void setTmuser_level_id(String tmuser_level_id) {
    this.tmuser_level_id = tmuser_level_id;
  }

  public String getJenis() {
    return jenis;
  }

  public void setJenis(String jenis) {
    this.jenis = jenis;
  }

  public String getP12() {
    return p12;
  }

  public void setP12(String p12) {
    this.p12 = p12;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public UserModel() {}
}
