/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.peminjaman.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buku {
    private Long bukuId;
    private String kode;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
}
