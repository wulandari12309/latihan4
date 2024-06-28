package com.kasirbaru2.service;

import com.kasirbaru2.entity.BarangEntity;
import com.kasirbaru2.repo.BarangRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarangService {
    @Autowired
    private BarangRepo barangRepo;


    @Transactional
    public BarangEntity saveBarang(BarangEntity barangEntity){
        barangEntity.setKodeBarang(generateKodeBarang());
        return barangRepo.save(barangEntity);
    }

    public String generateKodeBarang(){
        Long maxId = barangRepo.findMaxId();
        if (maxId == null) {
            maxId = 0L;
        }
        return "BRG" + (maxId + 1);
    }

    public Optional<BarangEntity> getBarangByNama(String namaBarang) {
        return barangRepo.findByNamaBarang(namaBarang);
    }


}
