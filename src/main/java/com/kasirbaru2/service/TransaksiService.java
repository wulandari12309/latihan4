package com.kasirbaru2.service;

import com.kasirbaru2.entity.TransaksiEntity;
import com.kasirbaru2.repo.TransaksiRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransaksiService {
    @Autowired
    private TransaksiRepo transaksiRepo;

    public TransaksiEntity saveTransaksi(TransaksiEntity transaksiEntity){
        return transaksiRepo.save(transaksiEntity);
    }
}
