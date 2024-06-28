package com.kasirbaru2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "data_kasir")
public class KasirEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namaKasir;
    private String noHpKasir;
    private String alamatKasir;
    private String passwordKasir;

    public KasirEntity() {}

    public KasirEntity(Long id, String namaKasir, String noHpKasir, String alamatKasir, String passwordKasir) {
        this.id = id;
        this.namaKasir = namaKasir;
        this.noHpKasir = noHpKasir;
        this.alamatKasir = alamatKasir;
        this.passwordKasir = passwordKasir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public String getNoHpKasir() {
        return noHpKasir;
    }

    public void setNoHpKasir(String noHpKasir) {
        this.noHpKasir = noHpKasir;
    }

    public String getAlamatKasir() {
        return alamatKasir;
    }

    public void setAlamatKasir(String alamatKasir) {
        this.alamatKasir = alamatKasir;
    }

    public String getpasswordKasir() {
        return passwordKasir;
    }

    public void setpasswordKasir(String passwordKasir) {
        this.passwordKasir = passwordKasir;
    }
}
