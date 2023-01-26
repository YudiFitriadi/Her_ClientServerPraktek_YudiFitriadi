/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.peminjaman.service.controller;

import com.yudi.peminjaman.service.entity.Peminjaman;
import com.yudi.peminjaman.service.service.PeminjamanService;
import com.yudi.peminjaman.service.vo.ResponseTemplateVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;
    
    @PostMapping("/")
    public Peminjaman savePeminjaman(@RequestBody Peminjaman peminjaman){
        return peminjamanService.savePeminjaman(peminjaman);
    }
    
    @GetMapping("{id}")
    public ResponseTemplateVO getPeminjaman(@PathVariable("id") Long peminjamanId){
        return (ResponseTemplateVO) peminjamanService.getPeminjaman(peminjamanId);
    }
    
    @GetMapping("/")
    public List<Peminjaman> getAllPeminjaman(){
        return (List<Peminjaman>) peminjamanService.getAllPeminjaman();
    }
    
    @PutMapping("")
    public Peminjaman updatePeminjaman(@RequestBody Peminjaman peminjaman){
        return peminjamanService.updatePeminjaman(peminjaman);
    }
    
    @DeleteMapping("/{id}")
    public void deletePeminjamanById(@PathVariable("id") Long peminjamanId){
        peminjamanService.deletePeminjamanById(peminjamanId);
    }
}
