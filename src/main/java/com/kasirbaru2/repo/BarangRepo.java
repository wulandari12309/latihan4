package com.kasirbaru2.repo;

import com.kasirbaru2.entity.BarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BarangRepo extends JpaRepository<BarangEntity, Long> {
    @Query("SELECT COALESCE(MAX(CAST(SUBSTRING(b.kodeBarang, 4)AS int)), 0) FROM BarangEntity b WHERE b.kodeBarang LIKE '%' AND b.kodeBarang LIKE 'BRG%'")
    Integer findMaxKodeBarang();

    @Query("SELECT COALESCE(MAX(b.id), 0) FROM BarangEntity b")
    Long findMaxId();

    Optional<BarangEntity> findByNamaBarang(String namaBarang);

}

