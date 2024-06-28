package com.kasirbaru2.controller;

import com.kasirbaru2.entity.KategoriEntity;
import com.kasirbaru2.repo.KategoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class KategoriController {
    @Autowired
    private KategoriRepo kategoriRepo;

    @PostMapping("/kategori")
    public ResponseEntity<String> savedKategori(@RequestBody KategoriEntity kategoriEntity){
        kategoriEntity.setTanggal(new Date());
        KategoriEntity savedKategori = kategoriRepo.save(kategoriEntity);
        return ResponseEntity.ok("kategori berhasil ditambahkan");
    }

    @GetMapping("/kategori")
    public ResponseEntity<List<KategoriEntity>> getAllKategori() {
        List<KategoriEntity> kategoriList = kategoriRepo.findAll();
        return ResponseEntity.ok(kategoriList);
    }

    @PutMapping("/kategori/{id}")
    public ResponseEntity<?> updateKategori(@PathVariable Long id, @RequestBody KategoriEntity kategoriEntity) {
        return kategoriRepo.findById(id).map(kategori -> {
            kategori.setNamaKategori(kategoriEntity.getNamaKategori());
            kategoriRepo.save(kategori);
            return ResponseEntity.ok().body("Kategori berhasil diupdate");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kategori tidak ditemukan"));
    }
}
