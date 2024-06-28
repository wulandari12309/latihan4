package com.kasirbaru2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "data_kategori")
public class KategoriEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaKategori;
    private Date tanggal;

    public KategoriEntity() {}

    public KategoriEntity(Long id, String namaKategori, Date tanggal) {
        this.id = id;
        this.namaKategori = namaKategori;
        this.tanggal = tanggal;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
