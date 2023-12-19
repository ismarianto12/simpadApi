package com.aplikaspajak.simpad.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sikd_satker")
class Sikd_satker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long Id;
  //   private String
}
