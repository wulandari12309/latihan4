package com.kasirbaru2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item-transaksi")
public class ItemTransaksiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kodeBarang;
    private String namaBarang;
    private Double hargaBarang;
    private int qty;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private TransaksiEntity transaksiEntity;

    public ItemTransaksiEntity(){}

    public ItemTransaksiEntity(Long id, String kodeBarang, String namaBarang, Double hargaBarang, int qty, Double subtotal, TransaksiEntity transaksiEntity) {
        this.id = id;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.qty = qty;
        this.subtotal = subtotal;
        this.transaksiEntity = transaksiEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public TransaksiEntity getTransaksiEntity() {
        return transaksiEntity;
    }

    public void setTransaksiEntity(TransaksiEntity transaksiEntity) {
        this.transaksiEntity = transaksiEntity;
    }
}

