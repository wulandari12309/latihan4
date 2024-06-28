package com.kasirbaru2.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "data_barang")
public class BarangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaBarang;
    private String kodeBarang;
    private Integer stokBarang;
    private Integer kategoriBarang;
    private Integer hargaModal;
    private Integer hargaJual;
    private Date tanggal;

    public BarangEntity(){}

    public BarangEntity(Long id, String namaBarang, String kodeBarang, Integer stokBarang, Integer kategoriBarang, Integer hargaModal, Integer hargaJual, Date tanggal) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.kodeBarang = kodeBarang;
        this.stokBarang = stokBarang;
        this.kategoriBarang = kategoriBarang;
        this.hargaModal = hargaModal;
        this.hargaJual = hargaJual;
        this.tanggal = tanggal;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public Integer getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(Integer stokBarang) {
        this.stokBarang = stokBarang;
    }

    public Integer getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(Integer kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public Integer getHargaModal() {
        return hargaModal;
    }

    public void setHargaModal(Integer hargaModal) {
        this.hargaModal = hargaModal;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    @PrePersist
    public void prePersist() {
        if (kodeBarang == null || kodeBarang.isEmpty()) {
            kodeBarang = generateKodeBarang();
        }
    }

    private String generateKodeBarang() {
        // Generate a unique kodeBarang here (e.g., using a UUID or a sequential number)
        return "KB" + System.currentTimeMillis(); // Example implementation
    }
}



