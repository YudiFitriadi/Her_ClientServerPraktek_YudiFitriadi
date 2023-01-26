/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.pelanggan.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yudi.pelanggan.service.entity.Pelanggan;
import com.yudi.pelanggan.service.repository.PelangganRepository;

/**
 *
 * @author user
 */
@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;
    
    public Pelanggan savePelanggan(Pelanggan pelanggan){
        return pelangganRepository.save(pelanggan);
    }
    
    public Pelanggan findPelangganById(Long pelangganId){
        return pelangganRepository.findByPelangganId(pelangganId);
    }
}
