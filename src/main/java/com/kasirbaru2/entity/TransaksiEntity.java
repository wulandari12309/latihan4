package com.kasirbaru2.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class TransaksiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nota;
    private Date tanggal;
    private String namaKasir;
    private String catatan;
    private Double total;
    private Double pembayaran;
    private Double kembalian;

    @OneToMany(mappedBy = "transaksiEntity", cascade = CascadeType.ALL)
    private List<ItemTransaksiEntity> itemTransaksiEntities;

    // Di dalam TransaksiEntity.java
    public List<ItemTransaksiEntity> getItemTransaksiEntities() {
        return itemTransaksiEntities;
    }

    public void setItemTransaksiEntities(List<ItemTransaksiEntity> itemTransaksiEntities) {
        this.itemTransaksiEntities = itemTransaksiEntities;
    }


    public TransaksiEntity(){}

    public TransaksiEntity(Long id, String nota, Date tanggal, String namaKasir, String catatan, Double total, Double pembayaran, Double kembalian) {
        this.id = id;
        this.nota = nota;
        this.tanggal = tanggal;
        this.namaKasir = namaKasir;
        this.catatan = catatan;
        this.total = total;
        this.pembayaran = pembayaran;
        this.kembalian = kembalian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Double pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Double getKembalian() {
        return kembalian;
    }

    public void setKembalian(Double kembalian) {
        this.kembalian = kembalian;
    }
}
