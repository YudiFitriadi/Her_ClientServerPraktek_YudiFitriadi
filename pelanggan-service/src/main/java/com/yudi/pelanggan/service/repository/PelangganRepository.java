/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.pelanggan.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yudi.pelanggan.service.entity.Pelanggan;

/**
 *
 * @author user
 */
@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long>{
    public Pelanggan findByPelangganId(Long pelangganId);
    
}

