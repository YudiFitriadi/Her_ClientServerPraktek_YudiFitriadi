/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.anggotaservice.repository;

import com.yudi.anggotaservice.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Long> {

    public Anggota findByAnggotaId(Long anggotaId);
    
}
