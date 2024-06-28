package com.kasirbaru2.controller;

import com.kasirbaru2.entity.BarangEntity;
import com.kasirbaru2.repo.BarangRepo;
import com.kasirbaru2.service.BarangService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BarangController {
    @Autowired
    private BarangService barangService;

    @Autowired
    private BarangRepo barangRepo;

    @PostMapping("/tambah-barang")
    public ResponseEntity<String> tambahBarang(@RequestBody BarangEntity barangEntity){
        barangEntity.setTanggal(new Date());
        BarangEntity savedBarang = barangService.saveBarang(barangEntity);
        return ResponseEntity.ok("barang berhasil ditambah");
    }

    @GetMapping("/next-kode")
    public ResponseEntity<String> getNextKodeBarang() {
        String nextKodeBarang = barangService.generateKodeBarang();
        return ResponseEntity.ok(nextKodeBarang);
    }

    @GetMapping("/daftar-barang")
    public ResponseEntity<List<BarangEntity>> getAllBarang(){
        List<BarangEntity> barangList = barangRepo.findAll();
        return ResponseEntity.ok(barangList);
    }

    @PutMapping("/edit-barang/{id}")
    public ResponseEntity<String> editBarang(@PathVariable Long id, @RequestBody BarangEntity barangEntity) {
        Optional<BarangEntity> barangData = barangRepo.findById(id);
        if (barangData.isPresent()) {
            BarangEntity existingBarang = barangData.get();
            existingBarang.setNamaBarang(barangEntity.getNamaBarang());
            existingBarang.setKategoriBarang(barangEntity.getKategoriBarang());
            existingBarang.setStokBarang(barangEntity.getStokBarang());
            existingBarang.setHargaModal(barangEntity.getHargaModal());
            existingBarang.setHargaJual(barangEntity.getHargaJual());
            existingBarang.setTanggal(new Date());
            barangRepo.save(existingBarang);
            return ResponseEntity.ok("Barang berhasil diupdate");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/hapus-barang/{id}")
    public ResponseEntity<String> hapusBarang(@PathVariable Long id){
        barangRepo.deleteById(id);
        return ResponseEntity.ok("berhasil dihapus");
    }

    @GetMapping("barang/{namaBarang}")
    public ResponseEntity<BarangEntity> getBarangByNama(@PathVariable String namaBarang) {
        Optional<BarangEntity> barang = barangService.getBarangByNama(namaBarang);
        if (barang.isPresent()) {
            return ResponseEntity.ok(barang.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
