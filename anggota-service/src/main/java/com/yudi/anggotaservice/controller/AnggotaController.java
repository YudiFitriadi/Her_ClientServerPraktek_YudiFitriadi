/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.anggotaservice.controller;

import com.yudi.anggotaservice.entity.Anggota;
import com.yudi.anggotaservice.service.AnggotaService;
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
@RequestMapping("/anggota")
public class AnggotaController {
    @Autowired
    private AnggotaService anggotaService;
    
    @PostMapping("/")
    public Anggota saveAnggota(@RequestBody Anggota anggota){
        return anggotaService.saveAnggota(anggota);
    }
    
    @GetMapping("/{id}")
    public Anggota findAnggotaById(@PathVariable("id") Long anggotaId){
        return anggotaService.findAnggotaById(anggotaId);
    }
    @GetMapping("/")
    public List<Anggota> getAllAnggota(){
        return anggotaService.getAllAnggota();
    }
    @PutMapping("/")
    public Anggota updateAnggota(@RequestBody Anggota anggota){
        return anggotaService.updateAnggota(anggota);
    }
    @DeleteMapping("/(id)")
    public void deleteAnggotaById(@PathVariable("id") Long angotaId){
        anggotaService.deleteAnggotaId(angotaId);
    }
   
}
