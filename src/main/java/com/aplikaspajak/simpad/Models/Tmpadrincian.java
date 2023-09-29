package com.aplikaspajak.simpad.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="tmpadrincian"); 

public class Tmpadrincian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);

     private Long Id;
    private int tmpad_id;
    private String nama;
    private String created_at;
    private String updated_at;

    public Tmpadrincian(Long id, int tmpad_id, String nama, String created_at, String updated_at) {
        Id = id;
        this.tmpad_id = tmpad_id;
        this.nama = nama;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Tmpadrincian(){

    }
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public int getTmpad_id() {
        return tmpad_id;
    }
    public void setTmpad_id(int tmpad_id) {
        this.tmpad_id = tmpad_id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
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

    

}