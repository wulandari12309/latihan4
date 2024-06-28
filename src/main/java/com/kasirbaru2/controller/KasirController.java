package com.kasirbaru2.controller;

import com.kasirbaru2.entity.KasirEntity;
import com.kasirbaru2.repo.KasirRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class KasirController {
    @Autowired
    private KasirRepo kasirRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpSession session;

    @PostMapping(path = "/daftar")
    public ResponseEntity<String> daftarKasir(@RequestBody KasirEntity kasirEntity){
        kasirEntity.setpasswordKasir(passwordEncoder.encode(kasirEntity.getpasswordKasir()));
        KasirEntity simpanKasir = kasirRepo.save(kasirEntity);
        return ResponseEntity.ok("daftar berhasil");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> loginKasir(@RequestBody KasirEntity kasirEntity, HttpServletRequest request){
        KasirEntity cariKasir = kasirRepo.findByNamaKasir(kasirEntity.getNamaKasir());
        if (cariKasir != null && passwordEncoder.matches(kasirEntity.getpasswordKasir(), cariKasir.getpasswordKasir())){
            HttpSession session = request.getSession();
            session.setAttribute("kasirId", cariKasir.getId());
            session.setAttribute("namaKasir", cariKasir.getNamaKasir());

            Map<String, String> response = new HashMap<>();
            response.put("message", "login berhasil");
            response.put("namaKasir", cariKasir.getNamaKasir());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "login gagal"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Logout berhasil");
    }

    @GetMapping("/transaksi")
    public ResponseEntity<Map<String, Object>> checkLoginForTransaksi(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Map<String, Object> response = new HashMap<>();

        if (session == null || session.getAttribute("kasirId") == null) {
            response.put("loggedIn", false);
            response.put("username", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            String namaKasir = (String) session.getAttribute("namaKasir");
            response.put("loggedIn", true);
            response.put("username", namaKasir);
            return ResponseEntity.ok(response);
        }
    }





}

