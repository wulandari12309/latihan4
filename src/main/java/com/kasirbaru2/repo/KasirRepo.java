package com.kasirbaru2.repo;

import com.kasirbaru2.entity.KasirEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KasirRepo extends JpaRepository<KasirEntity, Long> {
    KasirEntity findByNamaKasir(String namaKasir);
}

