/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.peminjaman.service.service;

import com.yudi.peminjaman.service.entity.Peminjaman;
import com.yudi.peminjaman.service.repository.PeminjamanRepository;
import com.yudi.peminjaman.service.vo.Anggota;
import com.yudi.peminjaman.service.vo.Buku;
import com.yudi.peminjaman.service.vo.ResponseTemplateVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author user
 */
@Service
public class PeminjamanService {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
    
    public ResponseTemplateVO getPeminjaman(Long peminjamanId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Peminjaman peminjaman = 
                peminjamanRepository.findByPeminjamanId(peminjamanId);
        Anggota anggota = 
        restTemplate.getForObject("http://localhost:9001/anggota/"
                + peminjaman.getAnggotaId(), Anggota.class);
        Buku buku = 
        restTemplate.getForObject("http://localhost:9005/buku/" 
                + peminjaman.getBukuId(), Buku.class);
        vo.setPeminjaman(peminjaman);
        vo.setAnggota(anggota); 
        vo.setBuku(buku); 
        return vo;
    }
    public List<Peminjaman> getAllPeminjaman(){
        return peminjamanRepository.findAll();
    }
    
    public void deletePeminjamanById(Long peminjamanId){
        peminjamanRepository.deleteById(peminjamanId);
    }
    
    public Peminjaman updatePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
}
