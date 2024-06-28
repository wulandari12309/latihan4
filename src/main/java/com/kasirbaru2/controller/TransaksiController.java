package com.kasirbaru2.controller;

import com.kasirbaru2.entity.ItemTransaksiEntity;
import com.kasirbaru2.entity.TransaksiEntity;
import com.kasirbaru2.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TransaksiController {
    @Autowired
    private TransaksiService transaksiService;

//    // Di dalam TransaksiController.java
//    @PostMapping("/save-transaksi")
//    public ResponseEntity<String> saveTransaksi(@RequestBody TransaksiEntity transaksiEntity) {
//        System.out.println("Transaksi diterima: " + transaksiEntity);
//        TransaksiEntity simpanTransaksi = transaksiService.saveTransaksi(transaksiEntity);
//        if (simpanTransaksi != null) {
//            return ResponseEntity.ok("Transaksi berhasil disimpan!");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal menyimpan transaksi.");
//        }
//    }

    // Di dalam TransaksiController.java
    @PostMapping("/save-transaksi")
    public ResponseEntity<String> saveTransaksi(@RequestBody TransaksiEntity transaksiEntity) {
        System.out.println("Transaksi diterima: " + transaksiEntity);

        // Menambahkan transaksi ke setiap item transaksi
        if (transaksiEntity.getItemTransaksiEntities() != null) {
            for (ItemTransaksiEntity itemTransaksi : transaksiEntity.getItemTransaksiEntities()) {
                itemTransaksi.setTransaksiEntity(transaksiEntity);
            }
        }

        TransaksiEntity simpanTransaksi = transaksiService.saveTransaksi(transaksiEntity);
        if (simpanTransaksi != null) {
            return ResponseEntity.ok("Transaksi berhasil disimpan!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal menyimpan transaksi.");
        }
    }


}
